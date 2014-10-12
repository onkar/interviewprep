package test;

import junit.framework.Assert;
import main.Rotate2DMatrix;

import org.junit.Test;

public class Rotate2DMatrixTest {
  private Rotate2DMatrix rm;

  @Test
  public void test() {
    int[][] array = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    rm = new Rotate2DMatrix(array, 3, 3);
    array = rm.rotateBy90DegreesClockwise();
    Assert.assertEquals(7, array[0][0]);
    Assert.assertEquals(4, array[0][1]);
    Assert.assertEquals(1, array[0][2]);
    Assert.assertEquals(8, array[1][0]);
    Assert.assertEquals(5, array[1][1]);
    Assert.assertEquals(2, array[1][2]);
    Assert.assertEquals(9, array[2][0]);
    Assert.assertEquals(6, array[2][1]);
    Assert.assertEquals(3, array[2][2]);
  }
}
