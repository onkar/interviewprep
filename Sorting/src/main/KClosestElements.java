package main;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * <pre>
 * Given a sorted array arr[] and a value x, find the k closest elements to x in arr[]. 
 * Examples:
 * Input: k = 4, x = 35 
 * arr[] = {12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56} 
 * Output: 30 39 42 45
 * 
 * NOTE : the solution does not work for duplicates.
 * </pre>
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class KClosestElements {
  private final int[] arr;
  private final int size;
  private final int x;
  private final int k;

  public KClosestElements(int[] arr, int size, int x, int k) {
    this.arr = arr;
    this.size = size;
    this.x = x;
    this.k = k;
  }

  public List<Integer> findKClosest() {
    int left = findCrossOver(0, size - 1);
    int right = left + 1;
    int count = 0;
    List<Integer> result = Lists.newArrayList();
    
    if (arr[left] == x) {
      // x is at crossOverPoint index, decrement left because we aren't interested in x.
      --left;
    }
    
    while (left >= 0 && right < size && count < k) {
      if (x - arr[left] < arr[right] - x) {
        result.add(arr[left]);
        left--;
      } else {
        result.add(arr[right]);
        right++;
      }
      count++;
    }

    // If there are no more elements on the right side and we haven't found k elements yet, copy
    // remaining elements from the left side.
    while (count < k && left >= 0) {
      result.add(arr[left]);
      count++;
      left--;
    }

    // If there are no more elements on the left side, and we haven't found k elements yet, copy
    // remaining elements from the right side.
    while (count < k && right < size) {
      result.add(arr[right]);
      count++;
      right++;
    }

    return result;
  }

  /**
   * Cross over point is a point before which elements are smaller than or equal to x and after
   * which are greater than x. Use binary search technique to do this in O(logn) time.
   */
  private int findCrossOver(int low, int high) {
    if (arr[high] < x) {
      // Base case
      return high;
    }
    if (arr[low] > x) {
      // Base case
      return low;
    }
    int mid = (low + high) / 2;
    if (arr[mid] == x) {
      // If x is same as the middle element, the mid is the cross over point.
      return mid;
    }
    if (x < arr[mid]) {
      // If x is smaller than the middle element, then crossover element will be in the first half
      return findCrossOver(low, mid - 1);
    }
    // Else cross over point is in the second half
    return findCrossOver(mid + 1, high);
  }


}
