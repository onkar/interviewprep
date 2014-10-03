package test;

import junit.framework.Assert;
import main.SubArrayWithGivenSum;
import main.SubArrayWithGivenSum.SubArrayBoundary;

import org.junit.Test;

public class SubArrayWithGivenSumTest {
  private SubArrayWithGivenSum gs;

  @Test
  public void test() {
    int[] array = {15, 2, 4, 8, 9, 5, 10, 23};
    gs = new SubArrayWithGivenSum(array, array.length);
    SubArrayBoundary sab = gs.getSubarray(23);
    Assert.assertEquals(1, sab.start);
    Assert.assertEquals(4, sab.end);
    Assert.assertEquals(23, sab.sum);
  }
}
