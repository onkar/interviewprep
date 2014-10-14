package main;

/**
 * An element in a sorted array can be found in O(log n) time via binary search. But suppose I
 * rotate the sorted array at some pivot unknown to you beforehand. So for instance, 1 2 3 4 5 might
 * become 3 4 5 1 2. Devise a way to find an element in the rotated array in O(log n) time.
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class PivotedBinarySearch {
  private final int[] array;

  public PivotedBinarySearch(int[] array) {
    this.array = array;
  }

  public int search(int number) {
    int pivot = findPivot(0, array.length - 1);
    if (pivot == -1) {
      return -1;
    }
    if (array[pivot] == number) {
      return pivot;
    }
    if (array[0] <= number) {
      return binarySearch(0, pivot - 1, number);
    } else {
      return binarySearch(pivot + 1, array.length - 1, number);
    }
  }

  private int binarySearch(int low, int high, int number) {
    if (high < low) {
      return -1;
    }
    int mid = (low + high) / 2;
    if (number == array[mid]) {
      return mid;
    }
    if (number < array[mid]) {
      return binarySearch(low, mid - 1, number);
    } else {
      return binarySearch(mid + 1, high, number);
    }
  }

  // Pivot is the index of an element whose next element is smaller than the pivoted element
  private int findPivot(int low, int high) {
    if (high < low) {
      return -1;
    }
    if (low == high) {
      return low;
    }
    int mid = (low + high) / 2;
    // If array[mid] is greater than array[mid + 1], we have found the pivot
    if (mid < high && array[mid] > array[mid + 1]) {
      return mid;
    }

    if (array[low] >= array[mid]) {
      return findPivot(low, mid - 1);
    } else {
      return findPivot(mid + 1, high);
    }
  }
}
