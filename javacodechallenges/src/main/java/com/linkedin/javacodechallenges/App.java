package com.linkedin.javacodechallenges;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class App {
    public static void redactTextFile(String fileName, String[] redactedWordsArray) {

        try (BufferedReader reader = new BufferedReader(new FileReader("./MacBeth.txt"))) {

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("What file would you like to " +
                "redact information from?");
        String fileName = scanner.nextLine();

        System.out.println("What words would you like to redact? " +
                "Separate each word or phrase with a comma. " +
                "If you phrase includes punctuation, include " +
                "that in your input.");
        String redactedWords = scanner.nextLine();
        String[] redactedWordsList = redactedWords.split(",");

        redactTextFile(fileName, redactedWordsList);

        scanner.close();
    }
}
