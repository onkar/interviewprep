package main;

/**
 * Determine winner of 2/9 number game
 * 
 * Two players play the following game: they pick a random number N (less than 2 billion) then,
 * starting from 1, take turns multiplying the number from the previous turn with either 2 or 9
 * (their choice). Whoever reaches N first wins.
 * 
 * The candidate should write a function that given N decides who wins (first or second player?)
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 *
 */
public class WinnerOf2_9Game {
  public int getWhoWins(int n) {
    if (getWhichPlayerWins(0, 1, n) == 0) {
      return 1;
    } else {
      return 2;
    }
  }

  private int getWhichPlayerWins(int currentPlayer, int currentNumber, int targetNumber) {
    if (currentNumber * 9 >= targetNumber) {
      return currentPlayer;
    }
    int nextPlayer = (currentPlayer + 1) % 2;
    if (getWhichPlayerWins(nextPlayer, currentNumber * 2, targetNumber) == currentPlayer
        || getWhichPlayerWins(nextPlayer, currentNumber * 9, targetNumber) == currentPlayer) {
      return currentPlayer;
    } else {
      return nextPlayer;
    }
  }
}
