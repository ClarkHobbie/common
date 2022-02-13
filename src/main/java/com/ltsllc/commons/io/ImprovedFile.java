package com.ltsllc.commons.io;

import com.ltsllc.commons.LtsllcException;

import java.io.*;
import java.net.URI;

public class ImprovedFile extends File {
    public ImprovedFile (File file) {
        super(String.valueOf(file));
    }

    public ImprovedFile (String parent,String child) {
        super(parent, child);
    }

    public ImprovedFile (String pathname) {
        super(pathname);
    }

    public ImprovedFile (URI uri) {
        super(uri);
    }

    public static int BUFFER_SIZE = 8192;

    /*
     * make a copy of the file and return it
     *
     * get a temp location and copy the contents of the file and return that file.
     */
    public ImprovedFile copy() throws LtsllcException {
        ImprovedFile temp;

        try {
            File whatever = File.createTempFile("temp_", "");
            temp = new ImprovedFile(whatever);
        } catch (IOException ioException) {
            throw new LtsllcException("exception creating temp file", ioException);
        }

        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;

        try {
            fileInputStream = new FileInputStream(this);
            fileOutputStream = new FileOutputStream(temp);
        } catch (FileNotFoundException fileNotFoundException) {
            throw new LtsllcException("error opening file or tempfile", fileNotFoundException);
        }

        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead;

        try {
            for (bytesRead = fileInputStream.read(buffer); bytesRead > 0; bytesRead = fileInputStream.read(buffer)) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }
        } catch (IOException ioException) {
            throw new LtsllcException("exception reading from file or writing to file", ioException);
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                    fileInputStream = null;
                }
            }
            catch (IOException ioException) {
                throw new LtsllcException("exception trying to close input file", ioException);
            }
            try {

                if (fileOutputStream != null) {
                    fileInputStream.close();
                    fileOutputStream = null;
                }
            } catch (IOException ioException) {
                throw new LtsllcException("exception trying to close temp file", ioException);
            }
        }

        return temp;
    }
}
