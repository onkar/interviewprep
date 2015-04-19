package main;

public class KLargestElements {
  public static int[] get(int[] array, int k) {
    int kthLargest = findKthLargest(array, k);
    int[] result = new int[k];
    int index = 0;
    result[index] = kthLargest;
    for (int i = 0; i < array.length; i++) {
      if (array[i] > kthLargest) {
        result[index] = array[i];
        index++;
      }
    }
    return result;
  }

  private static int findKthLargest(int[] array, int k) {
    return findKthLargestUtil(array, 0, array.length - 1, k);
  }

  private static int findKthLargestUtil(int[] array, int start, int end, int k) {
    if (start > end)
      return -1;
    int pivot = findPivot(array, start, end);
    if (k < pivot - start) {
      return findKthLargestUtil(array, start, pivot - 1, k);
    } else if (k > pivot) {
      return findKthLargestUtil(array, pivot + 1, end, k - pivot);
    } else {
      return array[pivot];
    }
  }

  private static int findPivot(int[] array, int low, int high) {
    int pivot = array[high];
    int i = low - 1;
    for (int j = low; j < high; j++) {
      if (array[j] >= pivot) {
        i++;
        swap(array, i, j);
      }
    }
    swap(array, i + 1, high);
    return i + 1;
  }

  private static void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

}
