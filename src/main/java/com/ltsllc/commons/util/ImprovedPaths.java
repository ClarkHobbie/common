package com.ltsllc.commons.util;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * A collection of useful methods when dealing with {@link Path} objects.
 */
public class ImprovedPaths {
    public static Path toPath(File file) {
        String pathString = file.getAbsolutePath();
        Path path = Paths.get(pathString);
        return path;
    }

    public static Path appendToPath(Path path, String suffix) {
        String string = path + suffix;
        Path tempPath = Path.of (string);
        return tempPath;
    }

    public static Path toPath (String string) {
        return Path.of(string);
    }
}
