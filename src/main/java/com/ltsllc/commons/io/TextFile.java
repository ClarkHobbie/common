package com.ltsllc.commons.io;

import com.ltsllc.commons.util.ImprovedPaths;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


/******************************************************************************
 *
 * A file containing text
 *
 * This class represents a text file.  When created, it reads in the file
 * and makes available via getReader, which returns a java.io.Reader.
 *
 ******************************************************************************
 */
public class TextFile {
    /* the associated file */

    protected File file;

    /* an image of the file in memory */

    protected List<String> text = new ArrayList<>();

    protected Path path;

    /**************************************************************************
     * Create an empty instance of the class.
     *
     **************************************************************************/
    public TextFile() {
    }

    /**************************************************************************
     * Get the text in the file.
     *
     * @return The text in the file.
     *************************************************************************/
    public List<String> getText() {
        return text;
    }

    public TextFile (String fileName) {
        File file1 = new File(fileName);
        this (file1);
    }
    /*
     * Create a new instance of the class and read into memory if it exists.
     *
     * After calling this @readFile should return a java.io.reader to the
     * file.
     */
    public TextFile(File inFile) {
        file = inFile;
        path = ImprovedPaths.toPath(inFile);
        if (file.exists()) {
            load();
        }
    }


    public void setText (String[] newText) {
        ArrayList<String> arrayList = new ArrayList<>();
        text = new ArrayList<>();

        for (String string : newText) {
            text.add(string);
        }
    }

    public void write() {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        File file = path.toFile();

        if (file.exists()) {
            file.delete();
        }

        try {
            fileWriter = new FileWriter(file);
        } catch (IOException e) {
            throw new RuntimeException("cannot open file for writing, file " + file, e);
        }

        bufferedWriter = new BufferedWriter(fileWriter);
        for (String string : text) {

            try {
                bufferedWriter.write(string);
                bufferedWriter.newLine();
            } catch (IOException e) {
                throw new RuntimeException("error writing file, " + file, e);
            }
        }

        try {
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException("error closing text file, " + file, e);
        }
    }


    public void delete() {
        try {
            if (Files.exists(path))
                Files.delete(path);
        } catch (IOException e) {
            throw new RuntimeException("error deleting text file, " + path, e);
        }
    }

    public void load() {
        try {
            path = ImprovedPaths.toPath(file);
            text = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException("error reading file, " + path.toFile(),e);
        }
    }

    public InputStream getInputStream () {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        for (String string : text) {
            try {
                baos.write(string.getBytes());
            } catch (IOException e) {
                throw new RuntimeException("error writing to ByteArrayOutputStream", e);
            }
        }

        return new ByteArrayInputStream(baos.toByteArray());
    }

    public Reader getReader () {
        return new InputStreamReader(getInputStream());
    }

    public void setText(ArrayList<String> list) {
        String[] strings = list.toArray(getText().toArray(new String[0]));
        setText(strings);
    }

    public void store() {
        write();
    }
}
