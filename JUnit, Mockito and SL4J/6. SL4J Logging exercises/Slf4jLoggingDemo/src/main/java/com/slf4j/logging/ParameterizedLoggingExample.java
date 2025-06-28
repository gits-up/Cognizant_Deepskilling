package com.slf4j.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {
        String userName = "Sayak";
        int loginAttempts = 3;

        logger.info("User {} has attempted to log in {} times.", userName, loginAttempts);
        logger.debug("Debug mode for user {}", userName);
        logger.warn("Warning: user {} has exceeded the safe number of login attempts.", userName);
        logger.error("Error occurred while processing login for user {}", userName);
    }
}
