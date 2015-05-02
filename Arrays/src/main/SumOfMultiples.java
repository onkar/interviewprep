package main;

/**
 * What is the sum of all multiples of 3 or 5 below 1000?
 * 
 * Source - http://www.quora.com/What-is-the-sum-of-all-multiples-of-3-or-5-below-1000
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 *
 */
public class SumOfMultiples {
  public static int getSum(int n) {
    int sum = 0;
    for (int x = 1; x < n; x++) {
      if ((x % 3 == 0) || (x % 5 == 0)) {
        sum += x;
      }
    }
    return sum;
  }
}
