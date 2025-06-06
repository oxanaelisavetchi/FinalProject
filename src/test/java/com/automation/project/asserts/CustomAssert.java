package com.automation.project.asserts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;

public class CustomAssert {
    private static final Logger log = LoggerFactory.getLogger(CustomAssert.class);

    public static <T> void assertThat(String message, T actual, Matcher<T> matcher) {
        String fullMessage = "Assert that " + message;
        String logMessage = getActualExpectedMessage(fullMessage, String.valueOf(actual), String.valueOf(matcher));
        try {
            MatcherAssert.assertThat(fullMessage, actual, matcher);
            log.info("[PASS] {}",logMessage);
        } catch (AssertionError error) {
            log.error("[FAIL] {}",logMessage);
            throw new AssertionError(error.getMessage());
        }
    }

    private static String getActualExpectedMessage(String fullMessage, String actual, String expected) {
        return String.format("%s\n - [ ACTUAL ]: %s\n - [ EXPECTED ]: %s", fullMessage, actual, expected);
    }

}
