package main;

/**
 * Please implement a function which gets the minimal number of coins, whose value is v1, v2, …, vn,
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
   * For a better understanding let’s take this example: Given coins with values 1, 3, and 5. And
   * the sum S is set to be 11.
   * 
   * First of all we mark that for state 0 (sum 0) we have found a solution with a minimum number of
   * 0 coins. We then go to sum 1. First, we mark that we haven’t yet found a solution for this one
   * (a value of Infinity would be fine). Then we see that only coin 1 is less than or equal to the
   * current sum. Analyzing it, we see that for sum 1-V1= 0 we have a solution with 0 coins. Because
   * we add one coin to this solution, we’ll have a solution with 1 coin for sum 1. It’s the only
   * solution yet found for this sum. We write (save) it. Then we proceed to the next state – sum 2.
   * We again see that the only coin which is less or equal to this sum is the first coin, having a
   * value of 1. The optimal solution found for sum (2-1) = 1 is coin 1. This coin 1 plus the first
   * coin will sum up to 2, and thus make a sum of 2 with the help of only 2 coins. This is the best
   * and only solution for sum 2. Now we proceed to sum 3. We now have 2 coins which are to be
   * analyzed – first and second one, having values of 1 and 3. Let’s see the first one. There
   * exists a solution for sum 2 (3 – 1) and therefore we can construct from it a solution for sum 3
   * by adding the first coin to it. Because the best solution for sum 2 that we found has 2 coins,
   * the new solution for sum 3 will have 3 coins. Now let’s take the second coin with value equal
   * to 3. The sum for which this coin needs to be added to make 3 , is 0. We know that sum 0 is
   * made up of 0 coins. Thus we can make a sum of 3 with only one coin – 3. We see that it’s better
   * than the previous found solution for sum 3 , which was composed of 3 coins. We update it and
   * mark it as having only 1 coin. The same we do for sum 4, and get a solution of 2 coins – 1+3.
   * And so on.
   * 
   * @return
   */
  public int getMinCoins(int[] coins, int sum) {
    int[] min = new int[sum + 1];
    int n = coins.length;

    // Mark all elements in min array to infinity
    for (int i = 0; i < sum + 1; i++) {
      min[i] = Integer.MAX_VALUE;
    }

    // Set min[0] because we need 0 coins to achieve the sum of 0
    min[0] = 0;

    // Outer loop goes from 1 to sum
    for (int i = 1; i <= sum; i++) {
      // Inner loop goes from 0 to number of coins
      for (int j = 0; j < n; j++) {
        // First condition in if block finds out number of coins which are less than or equal to the
        // current sum i. The next condition after && says can we add 1 to the previous solution and
        // get a better result. If we can, then we update the min array for current sum i.
        if (coins[j] <= i && min[i - coins[j]] + 1 < min[i]) {
          min[i] = min[i - coins[j]] + 1;
        }
      }
    }
    return min[sum];
  }
}
