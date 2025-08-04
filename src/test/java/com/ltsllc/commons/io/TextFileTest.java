package com.ltsllc.commons.io;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class TextFileTest {

    /***
     * Test {@link TextFile}'s ability to use an array of Strings.
     */
    @Test
    void setText() {
        String[] text = {
                "hi there",
                "how are you?"
        };
        TextFile textFile = new TextFile();
        textFile.setText(text);

        assert (textFile.getText().size() > 0);
        assert (textFile.getText().get(0).equalsIgnoreCase("hi there"));
    }

    @Test
    void write() throws IOException {
        File file = new File("test");

        String[] actual = {
                "hello",
                "world"
        };

        try {
            if (file.exists()) {
                file.delete();
            }

            TextFile textFile = new TextFile(file);
            textFile.setText(actual);
            textFile.write();

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            List<String> list = new ArrayList<>();
            for (String string = bufferedReader.readLine(); string != null; string = bufferedReader.readLine()) {
                list.add(string);
            }

            List<String> actualList = new ArrayList<>();
            for (String string : actual) {
                actualList.add(string);
            }

            assert (actualList.equals(list));
        } finally {
            if (file.exists()) {
                file.delete();
            }
        }
    }

    @Test
    void storeByteArray () throws IOException {
        File file = new File("test");

        try {
            TextFile textFile = new TextFile(file);
            OutputStream outputStream = textFile.getOutputStream();
            outputStream.write("hello".getBytes());
            outputStream.write("world".getBytes());
            textFile.store();

            FileInputStream fileInputStream = new FileInputStream(file);
            String output = new String(fileInputStream.readAllBytes());

            assert (output.startsWith("hello"));
        } finally {
            if (file.exists()) {
                file.delete();
            }
        }
    }

    @Test
    void load() throws IOException {
        File file = new File("test");

        String[] actual = {
                "hello",
                "world"
        };

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            for (String string : actual) {
                fileOutputStream.write(string.getBytes());
            }
            fileOutputStream.close();

            TextFile textFile = new TextFile(file);
            textFile.load();

            String actualString = textFile.asString();

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            for (String string : actual) {
                baos.write(string.getBytes());
            }
            String expected = new String(baos.toByteArray());

            assert (actualString.equalsIgnoreCase(expected));
        } finally {
            if (file.exists()) {
                file.delete();
            }
        }
    }

    @Test
    void getInputStream() throws Exception {
        String[] text = {
                "hi there",
                "how are you?"
        };
        TextFile textFile = new TextFile();
        textFile.setText(text);
        String textAsString = textFile.asString();

        InputStream inputStream = textFile.getInputStream();
        String actual = new String(inputStream.readAllBytes());

        assert (textAsString.equalsIgnoreCase(actual));
    }

    @Test
    void getTextAsArray() {
        String[] text = {
                "hi there",
                "how are you?"
        };
        TextFile textFile = new TextFile();
        textFile.setText(text);

        String[] array = textFile.getTextAsArray();

        assert (text.length == array.length);
        for (int index = 0;index < text.length; index++) {
            assert (text[index].equalsIgnoreCase(array[index]));
        }
    }

    @Test
    void asString() throws IOException {
        String actual = "hi there";
        String[] strings = { actual };
        TextFile textFile = new TextFile();
        textFile.setText(strings);

        String string = textFile.asString();

        assert (actual.equalsIgnoreCase(string));
    }

    @Test
    void getOutputStream() throws IOException {
        String[] original = {
                "hello",
                "world"
        };

        StringBuilder stringBuilder = new StringBuilder();
        for (String string : original) {
            stringBuilder.append(string);
        }
        String originalString = stringBuilder.toString();

        TextFile textFile = new TextFile();
        OutputStream outputStream = textFile.getOutputStream();
        outputStream.write("hello".getBytes());
        outputStream.write("world".getBytes());
        String actual = new String(textFile.toBytes());

        assert (originalString.equalsIgnoreCase(actual));
    }

    @Test
    void writeByteArrayOutputStream() throws IOException {
        File file = new File("test");

        try {
            TextFile textFile = new TextFile(file);
            List<String> list = new ArrayList<>();
            list.add("whatever");
            textFile.setText(list);

            OutputStream outputStream = textFile.getOutputStream();
            outputStream.write("hello".getBytes());
            outputStream.write("world".getBytes());

            textFile.store();


            FileInputStream fileInputStream = new FileInputStream(file);
            String output = new String(fileInputStream.readAllBytes());
            fileInputStream.close();

            assert(output.startsWith("hello"));
        } finally {
            if (file.exists()) {
                file.delete();
            }
        }

    }

    @Test
    void writeText() throws IOException {
        File file = new File("test");

        try {
            TextFile textFile = new TextFile(file);
            List<String> list = new ArrayList<>();
            list.add("hello");
            list.add("world");
            textFile.setText(list);
            textFile.store();

            FileInputStream fileInputStream = new FileInputStream(file);
            String output = new String(fileInputStream.readAllBytes());
            fileInputStream.close();

            assert (output.startsWith("hello"));
        } finally {
            if (file.exists()) {
                file.delete();
            }
        }
    }
}