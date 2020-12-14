package com.epam.rd.java.basic.practice4;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {
    public static final Logger log = Logger.getLogger(Part1.class.getName());

    public static void main(String[] args) {
        System.out.println(Part1.delete(Demo.readFile("part1.txt")));
    }

    public static String delete(String input){
        StringBuffer stringBuilder;
        Pattern pat  = Pattern.compile("\\b\\w{4,}", Pattern.UNICODE_CHARACTER_CLASS |Pattern.MULTILINE |Pattern.CASE_INSENSITIVE);
        Matcher m = pat.matcher(input);
        stringBuilder = new StringBuffer();
        while (m.find()){
            m.appendReplacement(stringBuilder,m.group().substring(2));
        }
        m.appendTail(stringBuilder);
        return stringBuilder.toString().trim();
    }
}