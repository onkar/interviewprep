package main;

import java.util.List;

/**
 * There are n houses built in a line, each of which contains some value in it. A thief is going to
 * steal the maximal value in these houses, but he cannot steal in two adjacent houses because the
 * owner of a stolen house will tell his two neighbors on the left and right side. What is the
 * maximal stolen value?
 * 
 * For example, if there are four houses with values {6, 1, 2, 7}, the maximal stolen value is 13
 * when the first and fourth houses are stolen.
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class StolenValues {

  /**
   * Let f(i) be the function that denotes the maximum value stolen from the first house upto ith
   * house. And Vi be the amount present in the ith house. Now when the thief reaches ith house, he
   * has two options - either rob the house or skip it. So,
   * 
   * <pre>
   * f(i) = Max(Vi + f(i - 2) iff ith house is robbed, f(i - 1) iff ith house is skipped)
   * </pre>
   * 
   * @param values
   * @return
   */
  public int maxStolenAmount(List<Integer> values) {
    if (values.size() == 0) {
      // No elements in the list, return 0
      return 0;
    }
    if (values.size() == 1) {
      // One element in the list, return that element
      return values.get(0);
    }
    if (values.size() == 2) {
      // Two elements in the list, return the max amongst them
      return Math.max(values.get(0), values.get(1));
    }

    // Save 0th element
    int val1 = values.get(0);
    // Second element is the max between first and second
    int val2 = Math.max(values.get(0), values.get(1));
    int val = 0;
    for (int i = 2; i < values.size(); i++) {
      // Update val with the formula above. Since i is 2, we have to add 0th element to the current
      // and keep val2 as is
      val = Math.max(values.get(i) + val1, val2);
      // Update val1 and val2
      val1 = val2;
      val2 = val;
    }
    // Return val
    return val;
  }
}
