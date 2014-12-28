package main;

import java.util.HashMap;
import java.util.Map;

/**
 * Find in an array A of int values the number of all pairs of indices (i,j) so that A[i] + A[j] ==
 * K. For example, let A = { 1, 5, 9 } with K = 10 we get the pairs (0, 2), (2,0), and (1,1) and the
 * result of the algorithm should be 3.
 * 
 * @author onkar.deshpande@gmail.com(Onkar Deshpande)
 *
 */
public class KComplemantary {
  public int getKComplemantaryPairs(int[] array, int k) {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < array.length; i++) {
      int complemantaryVal = k - array[i];
      int temp = map.containsKey(complemantaryVal) ? map.get(complemantaryVal) : 0;
      map.put(complemantaryVal, temp + 1);
    }
    int counter = 0;
    for (int i = 0; i < array.length; i++) {
      counter += map.containsKey(array[i]) ? map.get(array[i]) : 0;
    }
    return counter;
  }
}
