package test;

import java.util.ArrayList;
import java.util.List;

import main.SumFourNumbersToTarget;

import org.junit.Test;

public class SumFourNumbersToTargetTest {
  @Test
  public void test() {
    int[] array = {1, 0, -1, 0, -2, 2};
    SumFourNumbersToTarget st = new SumFourNumbersToTarget();
    List<ArrayList<Integer>> result = st.getSum(array, 0);
    for (ArrayList<Integer> r : result) {
      System.out.print("(");
      for (int i : r) {
        System.out.print(i + " ");
      }
      System.out.print(")");
      System.out.println();
    }
  }
}
