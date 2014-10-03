package test;

import junit.framework.Assert;
import main.MinimumJumps;

import org.junit.Test;

public class MinimumJumpsTest {
  private MinimumJumps mj;

  @Test
  public void test() {
    int[] array = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
    mj = new MinimumJumps(array, array.length);
    Assert.assertEquals(3, mj.getMinJumps());
  }

}
