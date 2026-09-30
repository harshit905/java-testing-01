package com.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/** Plain log4j2 use: LogManager and parameterised messages survive every Log4Shell fix. */
public final class Logging {
    private static final Logger LOG = LogManager.getLogger(Logging.class);

    public static void announce(String who) {
        LOG.info("hello {}", who);
    }
}
