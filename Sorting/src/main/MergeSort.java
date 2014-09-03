package main;

/**
 * Time complexity : O(nlogn), Space complexity : O(n)
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class MergeSort {
  private int[] numbers;
  private int[] helper;
  private int Size;

  public void sort(int[] array) {
    this.numbers = array;
    this.Size = array.length;
    this.helper = new int[Size];
    mergeSort(0, Size - 1);
  }

  private void mergeSort(int low, int high) {
    if (low < high) {
      int mid = (low + high) / 2;
      mergeSort(low, mid);
      mergeSort(mid + 1, high);
      merge(low, mid, high);
    }
  }

  private void merge(int low, int mid, int high) {
    for (int i = low; i <= high; i++) {
      helper[i] = numbers[i];
    }
    int i = low;
    int j = mid + 1;
    int k = low;

    while (i <= mid && j <= high) {
      if (helper[i] <= helper[j]) {
        numbers[k] = helper[i];
        i++;
      } else {
        numbers[k] = helper[j];
        j++;
      }
      k++;
    }

    while (i <= mid) {
      numbers[k] = helper[i];
      i++;
      k++;
    }
  }
}
