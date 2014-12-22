package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given array find all the sets of two numbers that add up to a target number
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 *
 */
public class NumbersAddingToTarget {
  public List<ArrayList<Integer>> findNumbers(int[] array, int target) {
    List<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    Arrays.sort(array);
    int low = 0, high = array.length - 1;
    while (low <= high) {
      if (array[low] + array[high] < target) {
        low++;
      } else if (array[low] + array[high] > target) {
        high--;
      } else {
        ArrayList<Integer> r = new ArrayList<Integer>();
        r.add(array[low]);
        r.add(array[high]);
        result.add(r);
        low++;
        high--;
      }
    }
    return result;
  }
}
