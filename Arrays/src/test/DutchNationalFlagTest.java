package test;

import junit.framework.Assert;
import main.DutchNationalFlag;

import org.junit.Test;

public class DutchNationalFlagTest {
  private DutchNationalFlag dnf;

  @Test
  public void test() {
    int[] array = {1, 0, 2, 1, 1, 0, 2, 2};
    dnf = new DutchNationalFlag(array);
    array = dnf.sort();
    Assert.assertEquals(0, array[0]);
    Assert.assertEquals(0, array[1]);
    Assert.assertEquals(1, array[2]);
    Assert.assertEquals(1, array[3]);
    Assert.assertEquals(1, array[4]);
    Assert.assertEquals(2, array[5]);
    Assert.assertEquals(2, array[6]);
    Assert.assertEquals(2, array[7]);
  }

}
