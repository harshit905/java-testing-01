package com.example;

import com.google.common.collect.Lists;
import com.google.common.io.Files;

import java.io.File;
import java.util.List;

/** Guava: Files.createTempDir() is the API the advisory is about; it is deprecated in 32.x but still present. */
public final class Temp {
    public static File scratch() {
        return Files.createTempDir();
    }

    public static List<String> names(String... values) {
        return Lists.newArrayList(values);
    }
}
