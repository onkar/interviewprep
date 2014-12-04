package main;

/**
 * There are n stairs, each time one can climb 1 or 2. How many different ways to climb the stairs?
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 *
 */
public class ClimbStairs {
  public int numberOfWays(int n) {
    if (n <= 2)
      return n;
    int first = 1, second = 2;
    int third = 0;
    for (int i = 3; i <= n; i++) {
      third = first + second;
      first = second;
      second = third;
    }
    return third;
  }

  private final int[] array = new int[100];

  public int numberOfWaysDynamic(int n) {
    if (n <= 2)
      array[n] = n;
    if (array[n] > 0)
      return array[n];
    else
      array[n] = numberOfWaysDynamic(n - 1) + numberOfWaysDynamic(n - 2);
    return array[n];
  }
}
