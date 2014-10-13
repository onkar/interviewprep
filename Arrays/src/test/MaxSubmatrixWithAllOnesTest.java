package test;

import junit.framework.Assert;
import main.MaxSubmatrixWithAllOnes;
import main.MaxSubmatrixWithAllOnes.SubMatrix;

import org.junit.Test;

public class MaxSubmatrixWithAllOnesTest {
  private MaxSubmatrixWithAllOnes m;

  @Test
  public void test() {
    int[][] array =
        { {0, 1, 1, 0, 1}, {1, 1, 0, 1, 0}, {0, 1, 1, 1, 0}, {1, 1, 1, 1, 0}, {1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0}};
    m = new MaxSubmatrixWithAllOnes(array, 6, 5);
    SubMatrix sb = m.getSubMatrix();
    Assert.assertEquals(2, sb.i1);
    Assert.assertEquals(1, sb.j1);
    Assert.assertEquals(4, sb.i2);
    Assert.assertEquals(3, sb.j2);
  }
}
