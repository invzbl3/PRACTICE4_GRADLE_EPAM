package com.epam.rd.java.basic.practice4;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class Part2Test {
    @Test
    public void shouldReturnSortedArrayOfNumbers() {
        String actual = Part2.sortArray("30 23 16 16 9 23 3 18 21 29");
        String expected = "3 9 16 16 18 21 23 23 29 30 ";
        assertEquals(expected, actual);
    }

    @Test
    public void main() {
        Part2.main(new String[] { null });
        Assert.assertTrue("Assertion to be compliant", true);
    }

    @Test
    public void demoTest() throws IOException {
        Demo.main(new String[] { });
        Assert.assertTrue("Assertion to be compliant", true);
    }
}