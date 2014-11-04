package main;

/**
 * Given strings SUNDAY and SATURDAY. We want to convert SUNDAY into SATURDAY with minimum edits.
 * Source - https://www.youtube.com/watch?v=iYa9AqB3wPc
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class EditDistance {
  /**
   * <pre>
   * 
   *                |---- E(i - 1, j - 1) + diff (i, j)
   *                |
   * E(i, j) = min  |
   *                |---- E(i - 1, j) + 1
   *                |
   *                |---- E(i, j - 1) + 1
   * where 
   *                |--- 1 if x(i) != y(j) 
   * diff (i, j) =  | 
   *                |--- 0 if x(i) == y(j)
   * </pre>
   * 
   * @param x
   * @param y
   * @return
   */
  public int getMinEdits(String x, String y) {
    int cols = x.length();
    int rows = y.length();
    int[][] E = new int[rows + 1][cols + 1];
    for (int i = 0; i < cols + 1; i++) {
      E[0][i] = i;
    }
    for (int j = 0; j < rows + 1; j++) {
      E[j][0] = j;
    }
    for (int i = 1; i < rows + 1; i++) {
      for (int j = 1; j < cols + 1; j++) {
        E[i][j] =
            minimum(E[i - 1][j - 1] + diff(j - 1, i - 1, x, y), E[i - 1][j] + 1, E[i][j - 1] + 1);
      }
    }
    return E[rows][cols];
  }

  private int minimum(int i, int j, int k) {
    return Math.min(i, Math.min(j, k));
  }

  private int diff(int i, int j, String x, String y) {
    return x.charAt(i) != y.charAt(j) ? 1 : 0;
  }
}
