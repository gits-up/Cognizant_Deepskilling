package com.slf4j.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MultiAppenderExample {
    private static final Logger logger = LoggerFactory.getLogger(MultiAppenderExample.class);

    public static void main(String[] args) {
        logger.info("This INFO log goes to both Console and File.");
        logger.warn("This WARNING log goes to both Console and File.");
        logger.error("This ERROR log goes to both Console and File.");
    }
}
