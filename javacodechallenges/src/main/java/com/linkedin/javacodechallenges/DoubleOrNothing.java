package com.linkedin.javacodechallenges;

import java.util.Scanner;
import java.lang.Math;

public class DoubleOrNothing {

  private int high_score = 0;
  private String best_user = "Nobody";
  private int current_score = 0;
  private int difficulty = -1;
  private Scanner scanner = new Scanner(System.in);

  private String setupGame() {
    String uname = "";
    System.out.print("Please enter your name: ");
    uname = scanner.nextLine();

    System.out.println("Hello, " + uname + "! Welcome to Double or Nothing.");
    System.out.println("The current High Score is " + high_score + " by " + best_user);
    System.out.println("The rules are simple! Accept your score or risk it for the chance to double it.");
    System.out.println("Just be careful becuaues the more times you double, the more likely you are to lose!");

    current_score = (int) (Math.random() * 9) + 1;
    return uname;
  }

  private int getScore() {
    return current_score;
  }

  private boolean isDoubled() {
    int doubler = (int) (Math.random() * 20);

    if (difficulty < 16) {
      difficulty += 1;
    }
    if (doubler >= difficulty) {
      return true;
    }
    return false;
  }

  private int newScore() {
    if (isDoubled()) {
      return current_score * 2;
    }
    return 0;
  }

  private void gameLoop(String uname) {
    String continue_game = "";
    do {
      System.out.println();
      System.out.println("Hello, " + uname + "!");
      System.out.println("Your current score is: " + getScore());
      System.out.print("Would you like to try to double it? (Enter y or n) ");

      continue_game = scanner.nextLine();

      if (continue_game.trim().equals("y") || continue_game.trim().equals("Y")) {
        int nScore = newScore();
        if (nScore == 0) {
          System.out.println("AHHH!! You lost! Your final score is 0. Thanks for playing!");
          break;
        } else {
          current_score = nScore;
        }
      } else {
        System.out.println("Congrats!! You won! Your final score is " + getScore() + ". Thanks for playing!");
        if (current_score > high_score) {
          high_score = current_score;
          best_user = uname;
        }
      }
    } while (continue_game.trim().equals("y") || continue_game.trim().equals("Y"));
  }

  public void playGame() {
    String uname = setupGame();
    gameLoop(uname);
  }
}