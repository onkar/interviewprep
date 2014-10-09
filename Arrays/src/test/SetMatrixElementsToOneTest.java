package test;

import junit.framework.Assert;
import main.SetMatrixElementsToOne;

import org.junit.Test;

public class SetMatrixElementsToOneTest {
  private SetMatrixElementsToOne me;

  @Test
  public void test() {
    int[][] a = { {1, 0}, {0, 0}};
    me = new SetMatrixElementsToOne(a, 2, 2);
    me.setMatrix();
    Assert.assertEquals(0, a[1][1]);
    Assert.assertEquals(1, a[0][0]);
    Assert.assertEquals(1, a[0][1]);
    Assert.assertEquals(1, a[1][0]);
  }
}
