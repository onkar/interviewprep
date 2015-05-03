package main;

/**
 * Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents) and pennies
 * (1 cent), write code to calculate the number of ways of representing n cents.
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 *
 */
public class WaysToRepresentCents {
  public static int makeChange(int n, int denomination) {
    int nextDenom = 0;
    switch (denomination) {
      case 25:
        nextDenom = 10;
        break;
      case 10:
        nextDenom = 5;
        break;
      case 5:
        nextDenom = 1;
        break;
      case 1:
        return 1;
    }

    int ways = 0;
    for (int i = 0; i * denomination <= n; i++) {
      ways += makeChange(n - i * denomination, nextDenom);
    }
    return ways;
  }
}
