package main;

/**
 * Sort an array which contains numbers between 0, 1 and 2.
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class DutchNationalFlag {
  private final int[] array;

  public DutchNationalFlag(int[] array) {
    this.array = array;
  }

  public int[] sort() {
    int low = 0;
    int mid = 0;
    int high = array.length - 1;
    while (mid <= high) {
      switch (array[mid]) {
        case 0: {
          swap(low, mid);
          low++;
          mid++;
          break;
        }

        case 1: {
          mid++;
          break;
        }

        case 2: {
          swap(mid, high);
          high--;
        }
      }
    }
    return array;
  }

  private void swap(int a, int b) {
    int temp = array[a];
    array[a] = array[b];
    array[b] = temp;
  }
}
