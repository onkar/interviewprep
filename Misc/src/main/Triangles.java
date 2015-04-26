package main;

import java.util.ArrayList;
import java.util.Arrays;

public class Triangles {
  public static ArrayList<ArrayList<Integer>> get(int[] input) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if (input.length < 3) {
      return result;
    }
    Arrays.sort(input);
    for (int i = 0; i < input.length - 2; i++) {
      int k = i + 2;
      for (int j = i + 1; j < input.length; j++) {
        while (k < input.length && input[i] + input[j] > input[k]) {
          ArrayList<Integer> inner = new ArrayList<Integer>();
          inner.add(input[i]);
          inner.add(input[j]);
          inner.add(input[k]);
          result.add(inner);
          k++;
        }
      }
    }
    return result;
  }
}
