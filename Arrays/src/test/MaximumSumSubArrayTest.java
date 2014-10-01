package test;

import junit.framework.Assert;
import main.MaxiumSumSubArray;
import main.MaxiumSumSubArray.Result;

import org.junit.Test;

public class MaximumSumSubArrayTest {
  private MaxiumSumSubArray mssb;

  @Test
  public void test() {
    int[] array = {-1, -2, 3, 4, -5, 6};
    mssb = new MaxiumSumSubArray(array, array.length);
    Result r = mssb.getMaxSumSubArray();
    Assert.assertEquals(8, r.sum);
    Assert.assertEquals(2, r.i);
    Assert.assertEquals(5, r.j);
    
    int[] array1 = {-8, 2, 5, -7, 1, 0};
    mssb = new MaxiumSumSubArray(array1, array1.length);
    r = mssb.getMaxSumSubArray();
    Assert.assertEquals(7, r.sum);
    Assert.assertEquals(1, r.i);
    Assert.assertEquals(2, r.j);
  }
}
