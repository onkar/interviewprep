package main;

public class BinaryKnapsack {

  /**
   * <pre>
   * You either take the n-1th element with value vi and weight wi or leave it.
   * 
   *                                          ___ values[n - 1] + knapsack(w - weights[n - 1], weights, values, n - 1) [pick n-1 th item] 
   *                                         |
   * knapsack(W, weights, values, n) = max --
   *                                         |___ knapsack(w, weights, values, n - 1) [leave n-1th item]
   * </pre>
   * 
   * Complexity = 2^n for naive recursive solution
   * 
   * @param w
   * @param weights
   * @param values
   * @param n
   * @return
   */
  public static int knapsack(int w, int[] weights, int[] values, int n) {
    if (n == 0 || w == 0)
      return 0;
    if (weights[n - 1] > w)
      return knapsack(w, weights, values, n - 1);
    else
      return Math.max(values[n - 1] + knapsack(w - weights[n - 1], weights, values, n - 1),
          knapsack(w, weights, values, n - 1));
  }

  // O(n * w)
  public static int knapsackDynamic(int w, int[] weights, int[] values, int n) {
    int[][] solution = new int[n + 1][w + 1];
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= w; j++) {
        if (i == 0 || j == 0)
          solution[i][j] = 0;
        else if (weights[i - 1] <= j)
          solution[i][j] =
              Math.max(values[i - 1] + solution[i][w - weights[i - 1]], solution[i - 1][j]);
        else
          solution[i][j] = solution[i - 1][j];
      }
    }
    return solution[n][w];
  }
}
