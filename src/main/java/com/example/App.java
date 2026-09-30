package com.example;

import com.example.decoy.DecoyUse;

public final class App {
    public static void main(String[] args) throws Exception {
        Logging.announce("sca");
        System.out.println(JsonNumbers.fastParse("1.5") + DecoyUse.parse("2.5"));
        System.out.println(Temp.names("a", "b") + Paths.clean("a/../b"));
        System.out.println(YamlConfig.loadPlain("k: v") + " " + Web.build("https://example.invalid", "/x"));
    }
}
