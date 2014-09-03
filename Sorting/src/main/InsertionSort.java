package main;

/**
 * Time complexity : O(n^2), Space Complexity : O(1). Useful when number of elements in the array
 * are small. Also useful when most of the array is almost sorted and a few of them are misplaced.
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class InsertionSort {
  private final int array[];
  private final int size;

  public InsertionSort(int[] array, int size) {
    this.array = array;
    this.size = size;
  }

  public void sort() {
    int key, j;
    for (int i = 1; i < size; i++) {
      key = array[i];
      j = i - 1;
      // Move elements of array[0..i-1], that are greater than the key, one position ahead of their
      // current position
      while (j >= 0 && key < array[j]) {
        array[j + 1] = array[j];
        j--;
      }
      array[j + 1] = key;
    }
  }

}
