package main;

/**
 * <pre>
 * Minimum number of jumps to reach the end of an array.
 * 
 * Given an array of integers where each element represents the max number of steps that can be made
 * forward from that element. Write a function to return the minimum number of jumps to reach the
 * end of the array (starting from the first element). If an element is 0, then cannot move through
 * that element.
 * 
 * Example:
 * 
 * Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
 * Output: 3 (1-> 3 -> 8 ->9)
 * 
 * Time complexity = O(n^2)
 * </pre>
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class MinimumJumps {
  private final int[] array;
  private final int size;

  public MinimumJumps(int[] array, int size) {
    this.array = array;
    this.size = size;
  }

  // Create an array jumps[size] from left to right such that jumps[i] indicates minimum number of
  // jumps needed to reach array[i] from array[0]. Finally, we return jumps[n-1].
  public int getMinJumps() {
    int[] jumps = new int[size];
    // Set jumps[0] to 0 because no steps are needed to reach array[0].
    jumps[0] = 0;
    // Return Integer.MAX_VALUE if the condition is met.
    if (size == 0 || array[0] == 0) {
      return Integer.MAX_VALUE;
    }
    // i is the index which is ahead of j
    for (int i = 1; i < size; i++) {
      jumps[i] = Integer.MAX_VALUE;
      // For each i, j will start from 0 and calculate the minimum steps needed to reach array[i]
      for (int j = 0; j < i; j++) {
        if (i <= j + array[j] && jumps[j] != Integer.MAX_VALUE) {
          // This means that i is reachable from j, so now calculate the minimum number of jumps.
          jumps[i] = Math.min(jumps[j] + 1, jumps[i]);
          break;
        }
      }
    }
    return jumps[size - 1];
  }
}
