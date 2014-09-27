package main;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Given an array of size n and if the array contains numbers from 0 to k-1, (all positive) and k <=
 * n, find the maximum repeating number in the array.
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class MaxRepeatingElement {
  private final int[] array;
  private final int size;
  private final int k;

  public MaxRepeatingElement(int[] array, int size, int k) {
    this.array = array;
    this.size = size;
    this.k = k;
  }
  
  public int getMaxRepeating() {
    int[] occurence = new int[k + 1];
    for (int i = 0; i < size; i++) {
      occurence[array[i]]++;
    }
    int max = occurence[0];
    int maxIndex = 0;
    for (int i = 1; i < k + 1; i++) {
      if (max < occurence[i]) {
        max = occurence[i];
        maxIndex = i;
      }
    }
    return maxIndex;
  }

  public int getMaxRepeatingUsingHashMap() {
    Map<Integer, Integer> m = new HashMap<Integer, Integer>();
    for (int no : array) {
      if (m.containsKey(no)) {
        int count = m.get(no);
        count++;
        m.put(no, count);
      } else {
        m.put(no, 1);
      }
    }

    int max = 0, result = 0;
    for (Entry<Integer, Integer> e : m.entrySet()) {
      if (e.getValue() > max) {
        max = e.getValue();
        result = e.getKey();
      }
    }
    return result;
  }
}
