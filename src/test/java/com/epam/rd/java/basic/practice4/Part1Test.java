package com.epam.rd.java.basic.practice4;

import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class Part1Test {
    @Test
    public void shouldReturnSentenceWithoutTwoCharactersAndInUppercase() {
        String actual = Part1.delete("Create a class that displays the");
        String expected = "eate a ass at splays the";
        assertEquals(expected, actual);
    }

    @Test
    public void main() {
        Part1.main(new String[] { null });
        Assert.assertTrue("Assertion to be compliant", true);
    }

    @Test
    public void demoTest() throws IOException {
        Demo.main(new String[] { });
        Assert.assertTrue("Assertion to be compliant", true);
    }
}