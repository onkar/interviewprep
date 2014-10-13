package main;

/**
 * Find minimum and maximum element in an array with minimum comparisons.
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class MinMaxElementWithMinComparisons {
  private final int[] array;

  public static class MinMax {
    public int min;
    public int max;
  }

  public MinMaxElementWithMinComparisons(int[] array) {
    this.array = array;
  }

  // Create pairs and then compare the pairs
  public MinMax findMinMax() {
    MinMax mm = new MinMax();
    int i = 0;
    if (array.length % 2 == 0) {
      // Even number of elements. So min and max elements are different.
      if (array[0] > array[1]) {
        mm.max = array[0];
        mm.min = array[1];
      } else {
        mm.max = array[1];
        mm.min = array[0];
      }
      // Since we have scanned 2 elements, set i to 2.
      i = 2;
    } else {
      // Odd number of elements. So min and max elements are the same
      mm.max = array[0];
      mm.min = array[0];
      // Since we have scanned 1 element, set i to 1.
      i = 1;
    }

    while (i < array.length - 1) {
      // See if current element is smaller than the next
      if (array[i] < array[i + 1]) {
        // Check if the current element is smaller than minimum found so far. If yes, update the
        // minimum found so far.
        if (array[i] < mm.min) {
          mm.min = array[i];
        } else if (array[i + 1] > mm.max) {
          // Check if the next element is greater than the maximum found so far. If yes, update the
          // maximum found so far.
          mm.max = array[i + 1];
        }
      } else {
        // Check if current element is greater than the next one
        if (array[i] > mm.max) {
          // If current element is greater than the max element found so far, update the max
          mm.max = array[i];
        } else if (array[i + 1] < mm.min) {
          // If next element is smaller than the min found so far, update the min
          mm.min = array[i + 1];
        }
      }
      // Since we have scanned 2 elements, increment i by 2
      i += 2;
    }
    return mm;
  }
}
