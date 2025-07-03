package com.ltsllc.commons.io;

import org.junit.jupiter.api.Test;

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
    void getInputStream() {
    }
}