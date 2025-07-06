package com.ltsllc.commons.util;

import org.junit.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ImprovedPathsTest {
    @Test
    public void testToPath() {
        File file = new File("temp.txt");
        Path path = Paths.get(file.toString());

        assert (path != null);
        assert (path.toString().equalsIgnoreCase("temp.txt"));
    }

    @Test
    public void testAppendToPath() {
        Path path = Paths.get("temp.txt");
        String suffix = ".backup";
        String string = path + suffix;
        Path tempPath = Path.of (string);

        assert (tempPath != null);
        assert (tempPath.toString().equalsIgnoreCase("temp.txt.backup"));
    }
}
