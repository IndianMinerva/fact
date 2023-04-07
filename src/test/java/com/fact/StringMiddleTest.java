package com.fact;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringMiddleTest {

    private StringMiddle stringMiddle = new StringMiddle();

    @Test
    public void test_given_inputIsNull_shouldReturnEmptyString() {
        assertEquals("", stringMiddle.extractMiddleCharsOfString(null));
    }

    @Test
    public void test_given_inputIsEmptyString_shouldReturnEmptyString() {
        assertEquals("", stringMiddle.extractMiddleCharsOfString(""));
    }

    @Test
    public void test_given_inputIsOfEvenLength_shouldReturnMiddleTwoCharacters() {
        assertEquals("ab", stringMiddle.extractMiddleCharsOfString("ab"));
        assertEquals("cd", stringMiddle.extractMiddleCharsOfString("acdb"));
    }

    @Test
    public void test_given_inputIsOfOddLength_shouldReturnMiddleCharacter() {
        assertEquals("a", stringMiddle.extractMiddleCharsOfString("a"));
        assertEquals("c", stringMiddle.extractMiddleCharsOfString("acd"));
    }
}
