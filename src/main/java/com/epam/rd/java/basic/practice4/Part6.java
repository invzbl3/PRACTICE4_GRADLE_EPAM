package com.epam.rd.java.basic.practice4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part6 {
    public static final Logger LOGGER = Logger.getLogger(Part6.class.getName());
    
    public static void main(String[] args) {
        String input = Demo.readFile("part6.txt");
        outputSentence(input);
    }

    public static void outputSentence(String input) {
        String scanInput;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            while (!Objects.equals(scanInput = bufferedReader.readLine().toLowerCase(), "stop")) {
                switch (scanInput) {
                    case "latn":
                        System.out.println("Latn: " + outputLatin(input));
                        break;
                    case "cyrl":
                        System.out.println("Cyrl: " + outputCyrillic(input));
                        break;
                    default:
                        System.out.println(scanInput + ": Incorrect input");
                }
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Exception message : ", e);
        }
    }

    public static String outputCyrillic(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        String regex = "[\\u0410-\\u044F\\u0456\\u0457\\u0451\\u0406\\u0407\\u0454]+";
        Pattern pattern = Pattern.compile(regex, Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            stringBuilder.append(matcher.group()).append(" ");
        }
        return stringBuilder.toString();
    }

    public static String outputLatin(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        String regex = "[A-z]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            stringBuilder.append(matcher.group()).append(" ");
        }
        return stringBuilder.toString();
    }
}