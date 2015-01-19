package test;

import main.BinaryKnapsack;

import org.junit.Assert;
import org.junit.Test;

public class BinaryKnapsackTest {
  @Test
  public void test() {
    int[] val = {60, 100, 120};
    int weights[] = {10, 20, 30};
    int w = 50;
    Assert.assertEquals(220, BinaryKnapsack.knapsack(w, weights, val, val.length));
    Assert.assertEquals(220, BinaryKnapsack.knapsackDynamic(w, weights, val, val.length));
  }
}
