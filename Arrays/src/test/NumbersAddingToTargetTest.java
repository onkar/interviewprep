package test;

import java.util.ArrayList;
import java.util.List;

import main.NumbersAddingToTarget;

import org.junit.Assert;
import org.junit.Test;

public class NumbersAddingToTargetTest {
  @Test
  public void test() {
    int[] array = {8, 11, 2, 34, 1, 6, 9};
    NumbersAddingToTarget nat = new NumbersAddingToTarget();
    List<ArrayList<Integer>> result = nat.findNumbers(array, 10);

    ArrayList<Integer> a1 = result.get(0);
    Assert.assertEquals(a1.get(0).intValue(), 1);
    Assert.assertEquals(a1.get(1).intValue(), 9);

    ArrayList<Integer> a2 = result.get(1);
    Assert.assertEquals(a2.get(0).intValue(), 2);
    Assert.assertEquals(a2.get(1).intValue(), 8);
  }
}
