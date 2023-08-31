package com.linkedin.javacodechallenges;

import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class App {
    public static void redactTextFile(String fileName, String[] redactedWordsArray) {
        StringBuilder stringBuilder = new StringBuilder();
        String lineHolder = "";
        try (BufferedReader reader = new BufferedReader(
                new FileReader("javacodechallenges/src/main/java/com/linkedin/javacodechallenges/" + fileName))) {
            while ((lineHolder = reader.readLine()) != null) {
                for (String redact : redactedWordsArray) {
                    if (lineHolder.contains(redact)) {
                        lineHolder = lineHolder.replaceAll(redact, "REDACTED");
                    }
                }
                stringBuilder.append(lineHolder + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String redacted_text = stringBuilder.toString();

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("javacodechallenges/src/main/java/com/linkedin/javacodechallenges/REDACTED_"
                        + fileName))) {
            writer.write(redacted_text);
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
