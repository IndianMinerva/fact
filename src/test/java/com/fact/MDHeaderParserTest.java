package com.fact;

import junit.framework.JUnit4TestAdapter;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;


@RunWith(JUnitParamsRunner.class)
@Category(JUnit4TestAdapter.class)
public class MDHeaderParserTest {

    private MDHeaderParser mdHeaderParser = new MDHeaderParser();

    @Test
    @Parameters({
            "<h1>Hello World</h1>, # Hello World",
            "<h2>Hello World</h2>, ## Hello World",
            "<h3>Hello World</h3>, ### Hello World",
            "<h4>Hello World</h4>, #### Hello World",
            "<h5>Hello World</h5>, ##### Hello World",
            "<h6>Hello World</h6>, ###### Hello World",
    })
    public void test_given_correctHeader_shouldProduceMatchingHtml(String htmlString, String mdHeader) {
        assertEquals(htmlString, mdHeaderParser.getParsedHtml(mdHeader));
    }

    @Test
    public void test_given_correctHeaderWithSpacesAround_shouldRetainSpaces() {
        assertEquals(" <h1>Hello World</h1> ", mdHeaderParser.getParsedHtml(" # Hello World "));
        assertEquals("  <h2>Hello World</h2> ", mdHeaderParser.getParsedHtml("  ## Hello World "));
        assertEquals("   <h3>Hello World</h3> ", mdHeaderParser.getParsedHtml("   ### Hello World "));
        assertEquals("    <h4>Hello World</h4> ", mdHeaderParser.getParsedHtml("    #### Hello World "));
        assertEquals("     <h5>Hello World</h5> ", mdHeaderParser.getParsedHtml("     ##### Hello World "));
        assertEquals("      <h6>Hello World</h6> ", mdHeaderParser.getParsedHtml("      ###### Hello World "));
    }

    @Test
    public void test_given_tooManyHashesInHeader_shouldReturnHeaderText() {
        assertEquals(" Hello World ", mdHeaderParser.getParsedHtml(" ############### Hello World "));
    }

    @Test
    public void test_given_noHashesInHeader_shouldReturnHeaderText() {
        assertEquals("  Hello World ", mdHeaderParser.getParsedHtml("  Hello World "));
    }

    @Test
    public void test_given_tooManySpacesAfterHashes_shouldReturnHeaderText() {
        assertEquals("  ####  Hello World ", mdHeaderParser.getParsedHtml("  ####  Hello World "));
    }

}
