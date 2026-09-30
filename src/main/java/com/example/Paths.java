package com.example;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

/** commons-io: FilenameUtils.normalize is the fixed API; IOUtils.toString(InputStream) is deprecated but present through 2.14. */
public final class Paths {
    public static String clean(String path) {
        return FilenameUtils.normalize(path);
    }

    public static String slurp(InputStream in) throws IOException {
        return IOUtils.toString(in);
    }
}
