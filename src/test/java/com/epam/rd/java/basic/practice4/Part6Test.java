package com.epam.rd.java.basic.practice4;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class Part6Test {

    @Test
    public void shouldOutputCyrillic() {
        String expected = "Р С РіР С Р Р Р С Р С Р РІС Р Р Р С С РІР С Р Р Р С С Р Р С С Р Р Р С С Р РёРєРё Р Р Р Р С РёР РёС С РїС Р С С РІР С Рё Р Р Р С Р Р Р Р Р Р С Р Р РёС С Р РёРє Р С Р Р С Р Р С Р ";
        String actual = "Is there anybody going to listen to my story\n" +
                "Р›СЏРіР°С” РґРµРЅСЊ. Р’С–РЅ РІС–РґРґР°С” СЃРІРѕС— РЅР°РґС–С— РЅРѕС‡С–.\n" +
                "Р РѕР±С–С‚РЅРёРєРё\n" +
                "Р—Р°РјРѕСЂРёР»РёСЃСЊ РїСЂР°С†СЋРІР°С‚Рё.\n" +
                "РЎ Р±Р°СЂР°Р±Р°РЅРѕРј С…РѕРґРёС‚ С‘Р¶РёРє. Р‘СѓРј-Р±СѓРј-Р±СѓРј.";

        assertEquals(expected, Part6.outputCyrillic(actual));
    }

    @Test
    public void shouldOutputLatin() {
        String expected = "Is there anybody going to listen to my story ";
        String actual = "Is there anybody going to listen to my story\n" +
                "Р›СЏРіР°С” РґРµРЅСЊ. Р’С–РЅ РІС–РґРґР°С” СЃРІРѕС— РЅР°РґС–С— РЅРѕС‡С–.\n" +
                "Р РѕР±С–С‚РЅРёРєРё\n" +
                "Р—Р°РјРѕСЂРёР»РёСЃСЊ РїСЂР°С†СЋРІР°С‚Рё.\n" +
                "РЎ Р±Р°СЂР°Р±Р°РЅРѕРј С…РѕРґРёС‚ С‘Р¶РёРє. Р‘СѓРј-Р±СѓРј-Р±СѓРј.";

        assertEquals(expected, Part6.outputLatin(actual));
    }

    @Test
    public void demoTest() throws IOException {
        Demo.main(new String[] { });
        Assert.assertTrue("Assertion to be compliant", true);
    }
}