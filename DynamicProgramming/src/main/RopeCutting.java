package main;

/**
 * Given a rope of length n meters, cut the rope in different parts of integer lengths in a way that
 * maximizes product of lengths of all parts. You must make at least one cut. Assume that the length
 * of rope is more than 2 meters.
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class RopeCutting {

  /**
   * maxProd(n) = max( i * (n - i), maxProd(n - i) * i) for all 0 < i < n Basically, go through all
   * combinations and find out the max product. The complexity is O(n^2) and there are a lot of
   * subproblems which we are solving again and again.
   * 
   * <pre>
   * mP() ---> maxProd() 
   * 
   *                             mP(5)
   *                  /        /      \     \
   *                 /        /        \      \
   *             mP(4)       mP(3)     mP(2)   mP(1)
   *            /  |  \       /  \       |
   *           /   |   \     /    \      |  
   *      mP(3) mP(2) mP(1) mP(2) mP(1) mP(1)
   *     / \       |          |
   *    /   \      |          |   
   *  mP(2) mP(1) mP(1)      mP(1)
   * </pre>
   * 
   * @param n
   * @return
   */
  public int maxProduct(int n) {
    if (n == 0 || n == 1) {
      return 0;
    }
    int maxValue = 0;
    for (int i = 1; i < n; i++) {
      maxValue = max(maxValue, i * (n - i), maxProduct(n - i) * i);
    }
    return maxValue;
  }

  private int max(int a, int b, int c) {
    return Math.max(a, Math.max(b, c));
  }

  /**
   * Like typical dynamic programming problems, we save the result of earlier calculations in an
   * array and we refer to the array when needed instead of recalculating the subproblem. This is
   * O(n^2) time complexity with O(n) space complexity.
   * 
   * @param n
   * @return
   */
  public int maxProdBetter(int n) {
    // Size is n + 1 because the final result is going to be saved in value[n]
    int[] value = new int[n + 1];
    value[0] = value[1] = 0;
    for (int i = 1; i <= n; i++) {
      int maxValue = 0;
      for (int j = 1; j <= i / 2; j++) {
        maxValue = max(maxValue, j * (i - j), j * value[i - j]);
      }
      value[i] = maxValue;
    }
    return value[n];
  }

  /**
   * Maximum product can be obtained by repeatedly cutting parts of size 3 while the size is greater
   * than 4, keeping the last part as size of 2 or 3 or 4. For example, n = 10, the maximum product
   * is obtained by 3, 3, 4. For n = 11, the maximum product is obtained by 3, 3, 3, 2. This is O(1)
   * time complexity with O(1) space complexity.
   * 
   * @param n
   * @return
   */
  public int maxProdBest(int n) {
    if (n == 1 || n == 2) {
      return n - 1;
    }
    int result = 1;
    while (n > 4) {
      n = n - 3;
      result = result * 3;
    }
    return n * result;
  }

}
