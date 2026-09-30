package com.example;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

/** SnakeYAML: Constructor(Class) does not exist in 2.0; it needs a LoaderOptions argument there. */
public final class YamlConfig {
    public static class Settings {
        public String name;
        public int retries;
    }

    public static Settings load(String text) {
        Yaml yaml = new Yaml(new Constructor(Settings.class));
        return yaml.load(text);
    }

    public static Object loadPlain(String text) {
        return new Yaml().load(text);
    }
}
