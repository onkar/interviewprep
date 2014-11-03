package main;

/**
 * Please implement a function which gets the minimal number of coins, whose value is v1, v2, É, vn,
 * to make change for an amount of money with value t. Any coin with value vi may duplicate for any
 * times to make change.
 * 
 * For example, the minimal number of coins to make change for 15 out of a set of coins with value
 * 1, 3, 9, 10 is 3. We can choose two coins with value 3 and a coin with value 9. The number of
 * coins for other choices should be greater than 3.
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class MinCoinsForChange {
  /**
   * source : http://community.topcoder.com/tc?module=Static&d1=tutorials&d2=dynProg
   * 
   * <pre>
   * Set Min[i] equal to Infinity for all of i 
   * Min[0]=0
   * 
   * For i = 1 to S 
   *    For j = 0 to N - 1 
   *    If (Vj<=i AND Min[i-Vj]+1<Min[i]) 
   *    Then Min[i]=Min[i-Vj]+1
   * 
   * Output Min[S]
   * </pre>
   * 
   * @return
   */
  public int getMinCoins(int[] coins, int sum) {
    int[] min = new int[sum + 1];
    int n = coins.length;
    for (int i = 0; i < sum + 1; i++) {
      min[i] = Integer.MAX_VALUE;
    }
    min[0] = 0;
    for (int i = 1; i <= sum; i++) {
      for (int j = 0; j < n; j++) {
        if (coins[j] <= i && min[i - coins[j]] + 1 < min[i]) {
          min[i] = min[i - coins[j]] + 1;
        }
      }
    }
    return min[sum];
  }
}
