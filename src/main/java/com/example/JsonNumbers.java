package com.example;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.io.doubleparser.FastDoubleParser;

import java.io.IOException;

/** Number parsing on top of jackson-core. FastDoubleParser was REMOVED from jackson-core in 2.15.0. */
public final class JsonNumbers {
    private static final JsonFactory FACTORY = new JsonFactory();

    public static double fastParse(CharSequence text) {
        return FastDoubleParser.parseDouble(text);
    }

    public static String firstToken(String json) throws IOException {
        try (JsonParser parser = FACTORY.createParser(json)) {
            return String.valueOf(parser.nextToken());
        }
    }
}
