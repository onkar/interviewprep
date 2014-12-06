package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SumFourNumbersToTarget {
  public List<ArrayList<Integer>> getSum(int[] array, int target) {
    Arrays.sort(array);
    Set<ArrayList<Integer>> hashSet = new HashSet<ArrayList<Integer>>();
    List<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    for (int i = 0; i < array.length; i++) {
      for (int j = i + 1; j < array.length; j++) {
        int k = j + 1;
        int l = array.length - 1;
        while (k < l) {
          int sum = array[i] + array[j] + array[k] + array[l];
          if (sum > target) {
            l--;
          } else if (sum < target) {
            k++;
          } else if (sum == target) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(array[i]);
            temp.add(array[j]);
            temp.add(array[k]);
            temp.add(array[l]);
            if (!hashSet.contains(temp)) {
              hashSet.add(temp);
              result.add(temp);
            }
            k++;
            l--;
          }
        }
      }
    }
    return result;
  }
}
