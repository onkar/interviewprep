package main;

/**
 * Rearrange positive and negative numbers in O(n) time and O(1) space
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class Rearrange {
  private final int array[];
  private final int size;

  public Rearrange(int[] array, int size) {
    this.array = array;
    this.size = size;
  }

  public void rearrange() {
    int left = 0, right = size - 1;
    while (left < right) {
      if (array[left] < 0) {
        left++;
      } else if (array[right] > 0) {
        right--;
      } else {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
        left++;
        right--;
      }
    }
  }
}
