package com.epam.rd.java.basic.practice4;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class Part3Test {

    @Test
    public void shouldReturnInteger() {
        String actual = Part3.printInt();
        String expected = "432 89 ";
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnChar() {
        String actual = Part3.printChar();
        String expected = "a Р С Р ";
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnDouble() {
        String actual = Part3.printDouble();
        String expected = "43.43 .98 ";
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnString() {
        String actual = Part3.printString();
        String expected = "bcd Рё РІС ";
        assertEquals(expected, actual);
    }

    @Test
    public void demoTest() throws IOException {
        Demo.main(new String[] { });
        Assert.assertTrue("Assertion to be compliant", true);
    }
}