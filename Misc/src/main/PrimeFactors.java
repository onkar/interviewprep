package main;

public class PrimeFactors {
  public static void get(int n) {
    // Keep printing 2 until n becomes odd
    while (n % 2 == 0) {
      System.out.print("2 ");
      n = n / 2;
    }

    // Now n is odd. Start from i till sqroot(n) and see if i divides n. If yes, print i and update
    // n to n / i. Increment i = i + 2 since we are only interested in odd factors
    for (int i = 3; i <= Math.sqrt(n); i += 2) {
      while (n % i == 0) {
        System.out.print(i + " ");
        n = n / i;
      }
    }

    // If n hasn't been reduced by above two conditions, then n must be prime. So print n if it's
    // greater than 2.
    if (n > 2)
      System.out.print(n);
  }
}
