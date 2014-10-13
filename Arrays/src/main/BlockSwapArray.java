package main;

/**
 * <pre>
 * Block swap the given array.
 * Input = {1, 2, 3, 4, 5, 6, 7} and d = 2
 * Output = {3, 4, 5, 6, 7, 1, 2}
 * </pre>
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class BlockSwapArray {
  private final int[] array;

  public BlockSwapArray(int[] array) {
    this.array = array;
  }

  public int[] blockSwap(int d) {
    // Reverse first part of the array
    reverse(0, d - 1);
    // Reverse second part of the array
    reverse(d, array.length - 1);
    // Reverse the entire array
    reverse(0, array.length - 1);
    return array;
  }

  private void reverse(int start, int end) {
    while (start < end) {
      swap(start, end);
      start++;
      end--;
    }
  }

  private void swap(int start, int end) {
    int temp = array[start];
    array[start] = array[end];
    array[end] = temp;
  }
}
