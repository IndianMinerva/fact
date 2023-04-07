package org.example;

import org.junit.Test;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

public class MDHeaderParserTest {

    private MDHeaderParser mdHeaderParser = new MDHeaderParser();

    @Test
    @Parameterized.Parameters
    public void test_given_correctHeader_shouldProduceMatchingHtml() {
        assertEquals("<h1>Hello World</h1>", mdHeaderParser.getParsedHtml("# Hello World"));
        assertEquals("<h2>Hello World</h2>", mdHeaderParser.getParsedHtml("## Hello World"));
        assertEquals("<h3>Hello World</h3>", mdHeaderParser.getParsedHtml("### Hello World"));
        assertEquals("<h4>Hello World</h4>", mdHeaderParser.getParsedHtml("#### Hello World"));
        assertEquals("<h5>Hello World</h5>", mdHeaderParser.getParsedHtml("##### Hello World"));
        assertEquals("<h6>Hello World</h6>", mdHeaderParser.getParsedHtml("###### Hello World"));
    }
}
