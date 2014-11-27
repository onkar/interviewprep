package main;

import java.util.Arrays;

public class SumThreeNumbersToZero {

  // O(n^2) solution
  public void findThreeNumSumToZero(int[] array) {
    // Sort the array
    Arrays.sort(array);

    for (int i = 0; i < array.length; i++) {
      // Put head at the start of the array and tail at the end of the array
      int head = i + 1;
      int tail = array.length - 1;
      while (head < tail) {
        int sum = array[head] + array[tail] + array[i];
        if (sum > 0)
          tail--;
        else if (sum < 0)
          head++;
        else {
          System.out.print("[" + array[head] + " " + array[tail] + " " + array[i] + "]");
          System.out.println();
          break;
        }
      }
    }
  }
}
