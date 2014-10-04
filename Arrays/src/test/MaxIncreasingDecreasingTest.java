package test;

import main.MaxIncreasingDecreasing;

import org.junit.Assert;
import org.junit.Test;

public class MaxIncreasingDecreasingTest {
  private MaxIncreasingDecreasing mid;

  @Test
  public void test() {
    int[] array1 = {5, 11, 45, 39, 30, 20, 10, 5, 4, 3, 1};
    mid = new MaxIncreasingDecreasing(array1);
    Assert.assertEquals(45, mid.getMax(0, array1.length - 1));

    int[] array2 = {5, 55, 39, 30, 20, 10, 5, 4, 3, 1};
    mid = new MaxIncreasingDecreasing(array2);
    Assert.assertEquals(55, mid.getMax(0, array2.length - 1));
  }

}
