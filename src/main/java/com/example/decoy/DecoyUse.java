package com.example.decoy;

/** Calls the LOCAL FastDoubleParser, not jackson's. A grep for "FastDoubleParser" and "parseDouble" lands here too. */
public final class DecoyUse {
    public static double parse(String text) {
        return FastDoubleParser.parseDouble(text);
    }
}
