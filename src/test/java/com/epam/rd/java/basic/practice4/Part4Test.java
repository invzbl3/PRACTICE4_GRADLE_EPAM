package com.epam.rd.java.basic.practice4;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class Part4Test {

    @Test
    public void shouldReturnCutLatinSentence() {
        String expected = "The class should parse the text file and return sentences." +
                System.lineSeparator() +
                "The method 'iterator' of the given class should return the iterator object - an instance of the inner class." +
                System.lineSeparator() +
                "The method Iterator#remove should throw an exception UnsupportedOperationException." +
                System.lineSeparator();

        assertEquals(expected.trim(), Part4.getOutput());
    }

    @Test
    public void main() {
        Part4.main(new String[] { null });
        Assert.assertTrue("Assertion to be compliant", true);
    }

    @Test
    public void demoTest() throws IOException {
        Demo.main(new String[] { });
        Assert.assertTrue("Assertion to be compliant", true);
    }
}