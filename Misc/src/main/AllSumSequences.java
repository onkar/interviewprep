package main;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer, return all sequences of numbers that sum to it. For example, if n = 3, then you
 * should return {(1, 2), (2, 1), (1, 1, 1), (3)}
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 *
 */
public class AllSumSequences {
  public List<ArrayList<Integer>> getAllSumSequences(int n) {
    if (n == 0) {
      List<ArrayList<Integer>> outer = new ArrayList<ArrayList<Integer>>();
      ArrayList<Integer> inner = new ArrayList<Integer>();
      outer.add(inner);
      return outer;
    }

    List<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
    for (int i = 1; i <= n; i++) {
      List<ArrayList<Integer>> result = getAllSumSequences(n - i);
      for (ArrayList<Integer> l : result) {
        l.add(i);
        output.add(l);
      }
    }
    return output;
  }
}
