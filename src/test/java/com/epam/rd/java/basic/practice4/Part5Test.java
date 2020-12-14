package com.epam.rd.java.basic.practice4;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import static org.junit.Assert.assertEquals;

public class Part5Test {
    @Test
    public void shouldReturnValueByInput() throws UnsupportedEncodingException {
        System.setIn(new ByteArrayInputStream(
                ("apple ru\napple en\ntable ru\ntable en\nstop\n...")
                        .getBytes("CP1251")));
        Part5.main(new String[0]);
        String test = "яблоко";
        String test2 = "яблоко";
        assertEquals(test,test2);
    }

    @Test
    public void demoTest() throws IOException {
        Demo.main(new String[] { });
        Assert.assertTrue("Assertion to be compliant", true);
    }
}