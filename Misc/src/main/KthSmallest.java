package main;

/**
 * Find kth smallest number in an unsorted array using order statistics
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 *
 */
public class KthSmallest {
  public int getKthSmallest(int[] array, int k) {
    return findKthSmallestUtil(array, 0, array.length - 1, k);
  }

  private int findKthSmallestUtil(int[] array, int start, int end, int k) {
    if (start > end) {
      return -1;
    }
    int pivot = findPivot(array, start, end);
    if (k < pivot - start) {
      // Recurse in left subarray
      return findKthSmallestUtil(array, start, pivot - 1, k);
    } else if (k > pivot) {
      // Recurse in right subarray, note that we passed 'k - pivot' as 'k' since we have already
      // found out that k is not in the left half and k is greater than pivot
      return findKthSmallestUtil(array, pivot + 1, end, k - pivot);
    } else {
      return array[pivot];
    }
  }

  // Use quick sort logic to find the pivot
  private int findPivot(int[] array, int low, int high) {
    int pivot = array[high];
    int i = low - 1;
    for (int j = low; j < high; j++) {
      if (array[j] <= pivot) {
        i++;
        swap(i, j, array);
      }
    }
    swap(i + 1, high, array);
    return i + 1;
  }

  private void swap(int i, int j, int[] array) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
