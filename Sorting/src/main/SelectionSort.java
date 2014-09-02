package main;

/**
 * Selection sort - Time complexity : O(n^2), Space complexity : O(1). Since the algorithm never
 * makes more than n swaps, it is useful when memory write is a costly operation.
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class SelectionSort {
  private final int array[];
  private final int size;

  public SelectionSort(int arr[], int n) {
    this.array = arr;
    this.size = n;
  }

  private void sort() {
    int minimumIndex, j;

    for (int i = 0; i < size - 1; i++) {
      // Find index of the smallest number in the array
      minimumIndex = i;
      for (j = i + 1; j < size; j++) {
        if (array[j] < array[minimumIndex]) {
          minimumIndex = j;
        }
      }
      // Swap the smallest number with the first (ith) number
      swap(minimumIndex, i);
    }
  }

  private void swap(int minimumIndex, int i) {
    int temp = array[minimumIndex];
    array[minimumIndex] = array[i];
    array[i] = temp;
  }

  private void print() {
    for (int i = 0; i < size; i++) {
      System.out.print(array[i] + " ");
    }
    System.out.println("");
  }

  public static void main(String[] args) {
    int arr[] = {64, 25, 12, 22, 11};
    SelectionSort ss = new SelectionSort(arr, 5);
    ss.sort();
    ss.print();
  }

}
