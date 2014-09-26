package test;

import junit.framework.Assert;
import main.Rearrange;

import org.junit.Test;

public class RearrangeTest {
  private final int[] array = {-3, 5, 1, -1, 2, 11, -7};
  private final int size = 7;

  @Test
  public void test() {
    Rearrange r = new Rearrange(array, size);
    r.rearrange();
    Assert.assertEquals(-3, array[0]);
    Assert.assertEquals(-7, array[1]);
    Assert.assertEquals(-1, array[2]);
    Assert.assertEquals(1, array[3]);
    Assert.assertEquals(2, array[4]);
    Assert.assertEquals(11, array[5]);
    Assert.assertEquals(5, array[6]);
  }
}
