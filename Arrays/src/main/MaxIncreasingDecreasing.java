package main;

/**
 * Given array of integers which is initially in increasing order and then in decreasing order, find
 * the max element in the array.
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class MaxIncreasingDecreasing {
  private final int[] array;

  public MaxIncreasingDecreasing(int[] array) {
    this.array = array;
  }

  // Use binary search
  public int getMax(int low, int high) {
    if (low == high) {
      return array[low];
    }
    if (high == low + 1 && array[high] > array[low]) {
      return array[high];
    }
    if (high == low + 1 && array[low] > array[high]) {
      return array[low];
    }
    int mid = (low + high) / 2;
    if (array[mid] > array[mid - 1] && array[mid] > array[mid + 1]) {
      return array[mid];
    }
    if (array[mid] > array[mid + 1] && array[mid - 1] > array[mid]) {
      // Max element is in the left subarray
      return getMax(low, mid - 1);
    }
    if (array[mid] < array[mid + 1] && array[mid] > array[mid - 1]) {
      // Max element is in the right subarray
      return getMax(mid + 1, high);
    }

    // This should not happen
    return -1;
  }
}
