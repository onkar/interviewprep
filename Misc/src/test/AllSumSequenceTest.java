package test;

import java.util.ArrayList;
import java.util.List;

import main.AllSumSequences;

import org.junit.Test;

public class AllSumSequenceTest {
  @Test
  public void test() {
    AllSumSequences as = new AllSumSequences();
    List<ArrayList<Integer>> result = as.getAllSumSequences(3);
    for (int i = 0; i < result.size(); i++) {
      List<Integer> inner = result.get(i);
      for (int j = 0; j < inner.size(); j++) {
        System.out.print(inner.get(j) + " ");
      }
      System.out.println();
    }
  }
}
