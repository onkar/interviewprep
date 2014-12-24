package test;

import main.MergeKSortedArrays;

import org.junit.Assert;
import org.junit.Test;

public class MergeKSortedArraysTest {
  @Test
  public void test() {
    int[][] array = { {1, 3, 5, 7}, {2, 4, 6, 8}, {0, 9, 10, 11}};
    MergeKSortedArrays mksa = new MergeKSortedArrays();
    int[] result = mksa.merge(array);
    Assert.assertEquals(0, result[0]);
    Assert.assertEquals(1, result[1]);
    Assert.assertEquals(2, result[2]);
    Assert.assertEquals(3, result[3]);
    Assert.assertEquals(4, result[4]);
    Assert.assertEquals(5, result[5]);
    Assert.assertEquals(6, result[6]);
    Assert.assertEquals(7, result[7]);
    Assert.assertEquals(8, result[8]);
    Assert.assertEquals(9, result[9]);
    Assert.assertEquals(10, result[10]);
    Assert.assertEquals(11, result[11]);
  }
}
