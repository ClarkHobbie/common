package com.ltsllc.commons.io;

import com.ltsllc.commons.LtsllcException;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class ImprovedFileTest {

    @Test
    void copy() throws IOException, LtsllcException {
        ImprovedFile improvedFile = new ImprovedFile("c:/temp", "tempfile");
        if (improvedFile.exists()) {
            improvedFile.delete();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(improvedFile);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        outputStreamWriter.write("hi there");
        outputStreamWriter.close();
        fileOutputStream.close();

        ImprovedFile improvedFile2 = improvedFile.copy();

        FileInputStream fileInputStream = new FileInputStream(improvedFile2);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        char[] buffer = new char[1024];
        int bytesRead = inputStreamReader.read(buffer);
        String temp = new String(buffer, 0, bytesRead);
        assert ("hi there".equals(temp));

        improvedFile2.delete();
    }
}