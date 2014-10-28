package main;

/**
 * A board has n*m cells, and there is a gift with some value (value is greater than 0) in every
 * cell. You can get gifts starting from the top-left cell, and move right or down in each step, and
 * finally reach the cell at the bottom-right cell. What’s the maximal value of gifts you can get
 * from the board?
 * 
 * Source - http://codercareer.blogspot.com/2014/10/no-56-maximal-value-of-gifts.html
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class MaxValueGift {

  /**
   * It's a dynamic programming problem. A function f(i, j) is defined as the maximum value of gifts
   * when reaching the cell (i, j). There are two cells before cell (i,j) is reached. One is (i, j -
   * 1) and the other is (i - 1, j). So, f(i, j) = Max(f(i - 1, j), f(i, j - 1)) + gift(i, j). We
   * use the following iterative logic to get the maximum value.
   * 
   * @param gift
   * @return
   */
  public int getMaxValue(int[][] gift) {
    int rows = gift.length;
    int cols = gift[0].length;
    int maxValues[][] = new int[rows][cols];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        int left = 0;
        int up = 0;
        if (i > 0) {
          // Save f(i - 1, j) in up
          up = maxValues[i - 1][j];
        }
        if (j > 0) {
          // Save f(i, j - 1) in left
          left = maxValues[i][j - 1];
        }
        // Use the recursive definition and save the result in maxValues[i][j]
        maxValues[i][j] = Math.max(up, left) + gift[i][j];
      }
    }
    // maxValues[rows - 1][cols - 1] has the result
    return maxValues[rows - 1][cols - 1];
  }

}
