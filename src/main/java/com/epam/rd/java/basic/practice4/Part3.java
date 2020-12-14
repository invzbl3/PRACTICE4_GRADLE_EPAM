package com.epam.rd.java.basic.practice4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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
}