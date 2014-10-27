package main;

/**
 * Given a sorted array, find a number which matches its index in the array.
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class NumberMatchingIndex {
  public int[] array;

  public NumberMatchingIndex(int[] array) {
    this.array = array;
  }

  public int findNumberMatchingIndex() {
    int no = findNumberMatchingIndexRec(0, array.length - 1);
    return no;
  }

  private int findNumberMatchingIndexRec(int low, int high) {
    if (high < low) {
      return -1;
    }
    int mid = (low + high) / 2;
    if (array[mid] == mid) {
      return array[mid];
    }
    if (array[mid] < mid) {
      // Since the array is sorted, if array[mid] < mid, then all elements between 0 to mid are
      // smaller than their index, so there is no point in searching in the first part of the array.
      // So, we search in the right part of the array. Consider the following case - {-5, -3, -1, 2,
      // 4, 7, 11}
      return findNumberMatchingIndexRec(mid + 1, high);
    } else {
      // Similary, if this condition satisfies, then all elements between mid to end are greater
      // than their index, so we should search in the first part of the array.
      return findNumberMatchingIndexRec(low, mid - 1);
    }
  }

  public int findNumberMatchingIndexIterative() {
    int low = 0, high = array.length;
    boolean numberFound = false;
    int mid = 0;
    while (low <= high) {
      mid = (low + high) / 2;
      if (array[mid] == mid) {
        numberFound = true;
        break;
      }
      if (array[mid] < mid) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    if (numberFound) {
      return array[mid];
    } else {
      return -1;
    }
  }
}
