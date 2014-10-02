package test;

import junit.framework.Assert;
import main.MaximumMatrixSum;
import main.MaximumMatrixSum.MaxSumMatrix;

import org.junit.Test;

public class MaximumMatrixSumTest {
  private MaximumMatrixSum mms;
  private final int[][] array = {
      {1, -2, -1, -4, -20},
      {-8, -3, 4, 2, 1},
      {3, 8, 10, 1, 3},
      {-4, -1, 1, 7, 6}
  }; 
  private final int rows = 4;
  private final int cols = 5;

  @Test
  public void test() {
    mms = new MaximumMatrixSum(array, rows, cols);
    MaxSumMatrix msm = mms.getMaxSum();
    Assert.assertEquals(1, msm.left);
    Assert.assertEquals(4, msm.right);
    Assert.assertEquals(1, msm.top);
    Assert.assertEquals(3, msm.bottom);
    Assert.assertEquals(39, msm.maxSum);
  }

}
