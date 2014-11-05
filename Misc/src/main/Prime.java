package main;

import java.util.Arrays;

public class Prime {

  public boolean isPrime(int n) {
    if (n <= 1)
      return false;
    if (n == 2)
      return true;
    if (n % 2 == 0)
      return false;
    for (int i = 3; i <= Math.sqrt(n); i += 2) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  public boolean[] sieve(int n) {
    // Assume that all numbers upto and including n are prime. So set the prime array to true
    boolean[] prime = new boolean[n + 1];
    Arrays.fill(prime, true);

    prime[0] = false;
    prime[1] = false;

    // The outer loop runs from 2 to sqrt(n) which covers all necessary numbers
    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (prime[i]) {
        // If ith number is prime, mark all of its multiples to false
        for (int k = i * i; k <= n; k += i) {
          // Inner loop goes until n
          prime[k] = false;
        }
      }
    }
    // If prime[i] is true, i is prime, else i is not a prime number
    return prime;
  }
}
