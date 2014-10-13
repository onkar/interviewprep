package test;

import junit.framework.Assert;
import main.BlockSwapArray;

import org.junit.Test;

public class BlockSwapArrayTest {
  private BlockSwapArray bsa;

  @Test
  public void test() {
    int[] array1 = {1, 2, 3, 4, 5, 6, 7};
    bsa = new BlockSwapArray(array1);
    array1 = bsa.blockSwap(2);
    Assert.assertEquals(3, array1[0]);
    Assert.assertEquals(4, array1[1]);
    Assert.assertEquals(5, array1[2]);
    Assert.assertEquals(6, array1[3]);
    Assert.assertEquals(7, array1[4]);
    Assert.assertEquals(1, array1[5]);
    Assert.assertEquals(2, array1[6]);

    int[] array2 = {1, 2, 3, 4};
    bsa = new BlockSwapArray(array2);
    array2 = bsa.blockSwap(2);
    Assert.assertEquals(3, array2[0]);
    Assert.assertEquals(4, array2[1]);
    Assert.assertEquals(1, array2[2]);
    Assert.assertEquals(2, array2[3]);
  }

}
