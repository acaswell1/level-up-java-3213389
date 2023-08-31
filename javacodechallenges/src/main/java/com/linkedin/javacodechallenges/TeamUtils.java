package com.linkedin.javacodechallenges;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TeamUtils {

  public static void generateTeamsScores(List<Team> teams,
      int numberOfRounds) {
    Random random = new Random();
    teams.forEach(team -> {
      for (int i = 0; i < numberOfRounds; i++) {
        team.getScores().add(random.nextInt(11));
      }
    });
  }

  private static boolean checkGameStarted(int num_scores) {
    if (num_scores == 0) {
      System.out.println("The game hasn't started yet.");
      return false;
    } else {
      System.out.println("Now for the results, the WINNER is...");
      return true;
    }
  }

  private static void printResults(List<Integer> scores, List<String> toPrint) {
    int num_scores = scores.size();
    for (int i = 0; i < num_scores; i++) {
      if (i + 1 == num_scores) {
        System.out.println(toPrint.get(i) + "\n");
      } else if (scores.get(i) == scores.get(i + 1)) {
        System.out.println("It's a TIE!");
        System.out.println(toPrint.get(i));
        System.out.println(toPrint.get(i + 1) + "\n");
        i += 1;
      } else {
        System.out.println(toPrint.get(i) + "\n");
      }
      if (i != num_scores - 1) {
        System.out.println("Then we have... ");
      }
    }
  }

  public static void revealResults(List<Team> teams) {
    List<String> toPrint = new ArrayList<>();
    List<Integer> scores = new ArrayList<>();
    teams.stream()
        .sorted((team1, team2) -> team2.sumTotalScore() - team1.sumTotalScore())
        .forEach(team -> {
          if (team.sumTotalScore() > 0) {
            toPrint.add("With " + team.sumTotalScore() + " points, it's team "
                + team.getPlayer1() + " and " + team.getPlayer2() + "!");
            scores.add(team.sumTotalScore());
          }
        });

    int num_scores = scores.size();
    boolean game_started = checkGameStarted(num_scores);
    if (game_started) {
      printResults(scores, toPrint);
    }
  }
}