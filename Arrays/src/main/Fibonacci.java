package main;

public class Fibonacci {

  // This is bad because there are a lot of duplicate subproblems that are getting evaluated again
  // and again. This can be a lot of extra work if n is let's say 100.
  public long fibonacciBad(int n) {
    if (n <= 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }
    return fibonacciBad(n - 1) + fibonacciBad(n - 2);
  }

  // No duplicate subproblems, O(n) complexity
  public long fibonacciBetter(int n) {
    if (n <= 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }
    int fibMinusOne = 1;
    int fibMinusTwo = 0;
    int fibN = 0;
    for (int i = 2; i <= n; i++) {
      fibN = fibMinusOne + fibMinusTwo;
      fibMinusTwo = fibMinusOne;
      fibMinusOne = fibN;
    }
    return fibN;
  }
}
