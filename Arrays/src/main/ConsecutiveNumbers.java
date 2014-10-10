package main;

import java.util.HashSet;
import java.util.Set;

/**
 * Find if the given array elements are consecutive
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class ConsecutiveNumbers {
  private final int[] array;

  public ConsecutiveNumbers(int[] array) {
    this.array = array;
  }

  public boolean areConsecutive() {
    // Find min and max element of the array
    int min = findMin();
    int max = findMax();

    // This if condition should match
    if (array.length == max - min + 1) {
      Set<Integer> set = new HashSet<Integer>();
      // And additionally, all elements should be distinct, i.e. no duplicates
      for (int i = 0; i < array.length; i++) {
        if (!set.add(array[i])) {
          return false;
        }
      }
      return true;
    } else {
      return false;
    }
  }

  private int findMin() {
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < array.length; i++) {
      if (array[i] < min) {
        min = array[i];
      }
    }
    return min;
  }

  private int findMax() {
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < array.length; i++) {
      if (array[i] > max) {
        max = array[i];
      }
    }
    return max;
  }
}
