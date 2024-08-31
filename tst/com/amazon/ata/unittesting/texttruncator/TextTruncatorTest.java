package com.amazon.ata.unittesting.texttruncator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test the <code>TextTruncator</code> behavior.
 */
public class TextTruncatorTest {
    @Test
    public void truncateTo_stringLongerThanNumChars_shortensToFirstNumChars() {
        // GIVEN
        String original = "One two three four five";
        TextTruncator truncator = new TextTruncator(original);

        // WHEN
        String truncatedString = truncator.truncateTo(7);

        // THEN
        Assertions.assertEquals("One two", truncatedString,
                                "Expected to truncate to the first 7 characters");

    }

    /* ADD YOUR TESTS HERE */
    @Test
    public void trunctateTo_nullInput_returnsEmptyString() {
        //GIVEN
        String nullString = null;
        TextTruncator truncator = new TextTruncator(nullString);

        //WHEN
        String truncatedString = truncator.truncateTo(10);

        //THEN
        Assertions.assertEquals("", truncatedString, "Expected to truncate to empty string");
    }

    @Test
    public void truncateTo_stringLongerThanNumChars_shortensToDesiredLength() {
        //GIVEN
        String original = "Long strings are as long as they want to be, and some times longer.";
        TextTruncator truncator = new TextTruncator(original);
        int desiredLength = 16;

        //WHEN
        String truncatedString = truncator.truncateTo(desiredLength);

        //THEN
        Assertions.assertEquals("Long strings are", truncatedString,
                "Expected to truncate to desiredLength");
    }

    @Test
    public void truncateTo_stringNotLongerThanNumChars_doesNotAppendSuffix() {
        //GIVEN
        String original = "Long";
        TextTruncator truncator = new TextTruncator(original);

        //WHEN
        String truncatedString = truncator.truncateTo(4, "er");

        //THEN
        Assertions.assertEquals("Long", truncatedString, "Expected not to append suffix");
    }
}
