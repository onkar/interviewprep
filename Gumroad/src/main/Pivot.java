package main;

/**
 * Write a method that returns the "pivot" index of a list of integers. We define the pivot index as
 * the index where the sum of the numbers on the left is equal to the sum of the numbers on the
 * right. Given [1, 4, 6, 3, 2], the method should return 2, since the sum of the numbers to the
 * left of index 2 is equal to the sum of numbers to the right of index 2 (1 + 4 = 3 + 2). If no
 * such index exists, it should return -1. If there are multiple pivots, you can return the
 * left-most pivot.
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 *
 */
public class Pivot {
  public static int getPivot(int[] array) {
    // If there is one or zero element in the array, pivot cannot be found. So, return -1.
    if (array.length <= 1)
      return -1;

    int sum = 0, leftSum = 0;

    for (int i = 0; i < array.length; i++) {
      // Save the sum of all elements
      sum += array[i];
    }

    for (int i = 0; i < array.length; i++) {
      // Subtract each element from sum and see if reduced value equals leftSum
      sum -= array[i];
      if (sum == leftSum) {
        // If matched, return current index
        return i;
      }
      // Keep adding current element to leftSum
      leftSum += array[i];
    }

    // Pivot is not found after completely traversing the array, return -1.
    return -1;
  }
}
