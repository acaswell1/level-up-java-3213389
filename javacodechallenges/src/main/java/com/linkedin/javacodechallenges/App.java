package com.linkedin.javacodechallenges;

import java.util.Scanner;

public class App {

    public static boolean isPasswordComplex(String password) {
        int passwordLength = password.length();
        if (passwordLength > 6) {
            boolean capital = false, lowercase = false, num = false;
            for (int i = 0; i < passwordLength; i++) {
                char c = password.charAt(i);
                if ((int) c >= 'A' && (int) c <= 'Z') {
                    capital = true;
                }
                if ((int) c >= 'a' && (int) c <= 'z') {
                    lowercase = true;
                }
                if ((int) c >= '0' && (int) c <= '1') {
                    num = true;
                }
            }
            if (capital && lowercase && num) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a password: ");
        String userInput = scanner.nextLine();
        System.out.println("Is the password complex? "
                + isPasswordComplex(userInput));

        scanner.close();
    }
}
