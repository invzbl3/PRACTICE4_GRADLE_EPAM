package com.epam.rd.java.basic.practice4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/*
public class Part3 {
    public static final String PATH = "part3.txt";

    public static String printInt(){
        return input("(?<![-.])\\b[0-9]+\\b(?!\\.[0-9])");
    }
    public static String printChar(){
        return input("\\b[a-zа-яA-ZА-ЯЁёЇїІі]{1}\\b");
    }

    public static String printDouble(){
        return input("\\d*?\\.\\d+");
    }
    public static String printString(){
        return input("[а-яa-zA-ZА-ЯЁёЇїІі]{2,}");
    }

    private static String input(String ch) {
        String input = Demo.readFile(PATH);
        if (input != null) {
            Pattern pattern1 = Pattern.compile(ch);
            Matcher m1 = pattern1.matcher(input);
            StringBuilder latinStr = new StringBuilder();
            while (m1.find()) {
                String d = m1.group();
                latinStr.append(d).append(" ");
            }
            return latinStr.toString();
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean flag = true;
        do {
            String user = in.nextLine();
            if ("stop".equals(user) ) {
                flag = false;
            } else if ("char".equals(user)) {
                System.out.println(printChar());
            } else if ("int".equals(user)) {
                System.out.println(printInt());
            }  else if ("double".equals(user)) {
                System.out.println(printDouble());
            }else if ("String".equals(user)) {
                System.out.println(printString());
            }else {
                System.out.println("Incorrect input");
            }
        } while (flag);
    }
}*/

public class Part3 {
    public static final String REGEX_INT = "(?<!\\.)\\b\\d+\\b(?!\\.)";
    public static final String REGEX_DOUBLE = "\\d*\\.\\d+";
    public static final String REGEX_CHAR = "\\b\\w\\b";
    public static final String REGEX_STRING = "\\b[\\w&&\\D]{2,}\\b";
    public static final String FILE_CONTENT = Demo.readFile("part3.txt");
    private static final Logger LOGGER = Logger.getLogger(Part3.class.getName());

    public static void main(String[] args) {

        try {
            String consoleString;
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            while (!(consoleString = br.readLine()).equals("stop")) {
                System.out.println(getResultOperation(consoleString));
            }
            System.in.close();

        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "IOException", e);
        }

    }

    public static String getValuesFromFile(String regEx) {

        Pattern pattern = Pattern.compile(regEx, Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(FILE_CONTENT);
        StringBuilder stringBuilder = new StringBuilder();

        while (matcher.find()) {
            stringBuilder.append(matcher.group()).append(" ");
        }
        return stringBuilder.toString();

    }

    public static String getResultOperation(String inputData) {

        switch (inputData) {
            case "char":
                return getValuesFromFile(REGEX_CHAR);
            case "int":
                return getValuesFromFile(REGEX_INT);
            case "String":
                return getValuesFromFile(REGEX_STRING);
            case "double":
                return getValuesFromFile(REGEX_DOUBLE);
            case "stop":
                return "stop";
            default:
                return "Incorrect input";
        }
    }
}