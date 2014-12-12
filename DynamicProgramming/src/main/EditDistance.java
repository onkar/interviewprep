package main;

/**
 * Given strings SUNDAY and SATURDAY. We want to convert SUNDAY into SATURDAY with minimum edits.
 * Source -
 * http://programming4interviews.wordpress.com/2011/07/07/edit-distance-of-2-strings-using-dynamic
 * -programming/
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class EditDistance {
  /**
   * <pre>
   * 
   *                                           ____ 0 if (x.charAt(i - 1) == y.charAt(j - 1)
   *                                          |
   *                |---- E(i - 1, j - 1) + --
   *                |                         |____ 1 if (x.charAt(i - 1) != y.charAt(j - 1)
   *                |
   * E(i, j) = min  |
   *                |---- E(i - 1, j) + 1
   *                |
   *                |---- E(i, j - 1) + 1
   * </pre>
   * 
   * @param x
   * @param y
   * @return
   */
  public int getMinEdits(String x, String y) {
    int rows = x.length();
    int cols = y.length();
    int[][] E = new int[rows + 1][cols + 1];
    for (int i = 0; i <= rows; i++) {
      E[i][0] = i;
    }
    for (int j = 0; j <= cols; j++) {
      E[0][j] = j;
    }
    for (int i = 1; i <= rows; i++) {
      for (int j = 1; j <= cols; j++) {
        // NOTE : i-1 and j-1 indexes are checked because we want to make sure the string are in
        // the bounds. For i = 1 and j = 1, we want to check from the beginning so we are checking
        // i-1 and j-1th index
        if (x.charAt(i - 1) == y.charAt(j - 1)) {
          // If both characters match then there is no need to insert / delete / replace. So keep
          // the same edit distance as previous
          E[i][j] = E[i - 1][j - 1];
        } else {
          // Otherwise, get the minimum of insert / delete / replace
          E[i][j] = minimum(E[i - 1][j - 1] + 1, E[i][j - 1] + 1, E[i - 1][j] + 1);
        }
      }
    }
    return E[rows][cols];
  }

  private int minimum(int i, int j, int k) {
    return Math.min(i, Math.min(j, k));
  }
}
