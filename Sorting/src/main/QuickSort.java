package main;

/**
 * Best case time complexity : O(nlogn) when the pivoting logic always picks the medium element as
 * the pivot. Worst case time complexity : O(n^2) when the pivoting logic always picks a smallest or
 * the largest element as the pivot. Also, when the array is already sorted in ascending or
 * descending order. Average case time complexity : O(nlogn). Space complexity : O(n).
 * 
 * While quick sort works for most of the real world problems, merge sort is preferred when the data
 * is huge and stored in external memory (i.e. main memory is not sufficient for storing the data).
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class QuickSort {
  private final int[] array;

  public QuickSort(int[] array) {
    this.array = array;
  }

  public void sort(int low, int high) {
    if (low < high) {
      // Get the partition
      int p = partition(low, high);
      // Recursively sort both halves of the array except the partitioned element
      sort(low, p - 1);
      sort(p + 1, high);
    }
  }

  private int partition(int low, int high) {
    // Pick the right most element as the pivot
    int pivot = array[high];
    int i = low - 1;
    for (int j = low; j < high; j++) {
      if (array[j] <= pivot) {
        i++;
        swap(i, j);
      }
    }
    swap(i + 1, high);
    return i + 1;
  }

  private void swap(int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
