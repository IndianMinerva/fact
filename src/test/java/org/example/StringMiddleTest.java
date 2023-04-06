package org.example;

import org.junit.Assert;
import org.junit.Test;

public class StringMiddleTest {

    private StringMiddle stringMiddle = new StringMiddle();

    @Test
    public void test_given_inputIsNull_shouldReturnEmptyString() {
        Assert.assertEquals("", stringMiddle.extractMiddleCharsOfString(null));
    }

    @Test
    public void test_given_inputIsEmptyString_shouldReturnEmptyString() {
        Assert.assertEquals("", stringMiddle.extractMiddleCharsOfString(""));
    }

    @Test
    public void test_given_inputIsOfEvenLength_shouldReturnMiddleTwoCharacters() {
        Assert.assertEquals("ab", stringMiddle.extractMiddleCharsOfString("ab"));
        Assert.assertEquals("cd", stringMiddle.extractMiddleCharsOfString("acdb"));
    }

    @Test
    public void test_given_inputIsOfOddLength_shouldReturnMiddleCharacter() {
        Assert.assertEquals("a", stringMiddle.extractMiddleCharsOfString("a"));
        Assert.assertEquals("c", stringMiddle.extractMiddleCharsOfString("acd"));
    }
}
