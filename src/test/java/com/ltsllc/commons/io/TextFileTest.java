package com.ltsllc.commons.io;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class TextFileTest {

    /**************************************************************************
     * Test {@link TextFile}'s ability to use an array of Strings.
     **************************************************************************/
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
    void write() {
    }

    @Test
    void load() {
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
}