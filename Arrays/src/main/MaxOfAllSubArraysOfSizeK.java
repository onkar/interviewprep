package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <pre>
 * Find maximum of all subarrays of size k.
 * 
 * Input : [1, 2, 3, 1, 4, 5, 2, 3, 6] 
 * Output : [3, 3, 4, 5, 5, 5, 6]
 * </pre>
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class MaxOfAllSubArraysOfSizeK {
  private final int[] array;

  public MaxOfAllSubArraysOfSizeK(int[] array) {
    this.array = array;
  }

  public List<Integer> getMax(int k) {
    Queue<Integer> queue = new LinkedList<Integer>();
    List<Integer> result = new ArrayList<Integer>();
    int i = 0;
    while (i + k <= array.length) {
      for (int j = i; j < i + k; j++) {
        while (!queue.isEmpty() && array[j] >= queue.peek()) {
          queue.remove();
        }
        queue.add(array[j]);
      }
      i = i + 1;
      result.add(queue.remove());
    }
    return result;
  }
}
