package com.linkedin.javacodechallenges;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        DoubleOrNothing game = new DoubleOrNothing();
        Scanner scanner = new Scanner(System.in);
        do {
            game.playGame();
            System.out.println();
            System.out.print("Would you like to play again? (Enter y or n) ");
        } while (scanner.nextLine().trim().equals("y"));

        scanner.close();
    }
}
