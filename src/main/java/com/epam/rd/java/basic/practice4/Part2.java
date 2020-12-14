package com.epam.rd.java.basic.practice4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.Scanner;

public class Part2 {
    private static final  String ENCODING = "CP1251";
    private static final  String START_FILE = "part2.txt";
    private static final  String FINISH_FILE = "part2_sorted.txt";
    private static final  int N = 10;
    private static final  int MAX = 50;

    private static SecureRandom random = new SecureRandom();

    private static void writeFinishFile() {
        try (Scanner sc = new Scanner(new File(START_FILE), ENCODING);
             PrintWriter pr = new PrintWriter(new File(FINISH_FILE), ENCODING)){
            while (sc.hasNextLine()) {
                pr.write(sortArray(sc.nextLine()));
            }
        } catch (FileNotFoundException e) {
            System.out.println(START_FILE + " or " + FINISH_FILE
                    + " cannot be written");
        } catch (UnsupportedEncodingException e) {
            System.out.println("Unsupported encoding");
        }
    }

    private static void writeStartFile() {
        File file = new File(START_FILE);

        if (!file.exists()) {
            try (PrintWriter pr = new PrintWriter(file, ENCODING)) {
                pr.write(getRandomArray());
            } catch (FileNotFoundException e) {
                System.out.println(START_FILE + " cannot be written");
            } catch (UnsupportedEncodingException e) {
                System.out.println("Unsupported encoding");
            }
        }
    }

    public static String sortArray(String str) {
        String[] arr = str.split(" ");
        int[] arr2 = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            arr2[i] = Integer.parseInt(arr[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2.length - 1; j++) {
                if (arr2[j] > arr2[j + 1]) {
                    int temp = arr2[j];
                    arr2[j] = arr2[j + 1];
                    arr2[j + 1] = temp;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i: arr2) {
            sb.append(i).append(" ");
        }
        return sb.toString();
    }

    private static String getRandomArray() {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        while (count < N) {
            sb.append(random.nextInt(MAX)).append(" ");
            count++;
        }
        return sb.substring(0, sb.length() - 1);
    }

    private static String output() {
        String str = null;
        try (Scanner sc = new Scanner(new File(START_FILE), ENCODING);
             Scanner sc1 = new Scanner(new File(FINISH_FILE), ENCODING)) {
            StringBuilder sb = new StringBuilder();
            while (sc.hasNextLine()) {
                sb.append("input ==> ").append(sc.nextLine()).append(System.lineSeparator());
            }
            while (sc1.hasNextLine()) {
                sb.append("output ==> ").append(sc1.nextLine());
            }
            str = sb.substring(0, sb.length() - 1);

        } catch (FileNotFoundException e) {
            System.out.println(START_FILE + " or " + FINISH_FILE
                    + " not found");
        }
        return str;
    }

    public static void main(String[] args) {
        Part2.writeStartFile();
        Part2.writeFinishFile();
        System.out.println(Part2.output());
    }
}