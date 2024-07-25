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
    //Test 1: Make sure truncateTo() doesn't fail on a null String
    @Test
    public void truncateTo_whenStringIsNull_returnEmptyString() {
        //GIVEN
        String original = null;
        TextTruncator truncator = new TextTruncator(original);
        //WHEN
        String truncatedString = truncator.truncateTo(10);
        //THEN
        Assertions.assertEquals("", "", "Expected to return empty string in case of input string is null");
    }


    //Test2: Test that truncateTo() returns a truncated string of the desired length.
    @Test
    public void truncateTo_stringLongerThanNumChars_returnedStringLengthEqualTonumChar() {
        //GIVEN
        String original = "Hashmap is a data structure to store information in the form of key value pair";
        TextTruncator insTruncator = new TextTruncator(original);
        int numChar = 27;
        //WHEN
        String truncatedString = insTruncator.truncateTo(numChar);
        // THEN
        Assertions.assertEquals(numChar, truncatedString.length(), "truncated string length is equal to numChar sent in the parameter");

    }

    //Test 3: Make sure that truncateTo() doesn't append suffix if the original String is short enough
    @Test
    public void truncateTo_stringSorterThanNumChar_returnsStringSameAsOriginalWithoutSuffix() {
        //GIVEN
        String original = "Hello";
        TextTruncator truncator = new TextTruncator(original);
        int numChar = 15;
        //WHEN
        String truncatedString = truncator.truncateTo(numChar, "abc!!");
        //THEN
        Assertions.assertEquals(original, truncatedString, "Suffix is not added in the case when original string is smaller than the numChar");
    }

}
