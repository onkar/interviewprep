package test;

import junit.framework.Assert;
import main.NextGreaterElement;

import org.junit.Test;

public class NextGreaterElementTest {
  private NextGreaterElement nge;

  @Test
  public void test() {
    int[] array = {11, 13, 21, 3};
    nge = new NextGreaterElement(array);
    array = nge.getNextGreater();
    Assert.assertEquals(13, array[0]);
    Assert.assertEquals(21, array[1]);
    Assert.assertEquals(-1, array[2]);
    Assert.assertEquals(-1, array[3]);

    int[] array2 = {18, 9, 22, 5, 3};
    nge = new NextGreaterElement(array2);
    array2 = nge.getNextGreater();
    Assert.assertEquals(22, array2[0]);
    Assert.assertEquals(22, array2[1]);
    Assert.assertEquals(-1, array2[2]);
    Assert.assertEquals(-1, array2[3]);
    Assert.assertEquals(-1, array2[4]);

    int[] array3 = {4, 5, 2, 25};
    nge = new NextGreaterElement(array3);
    array3 = nge.getNextGreater();
    Assert.assertEquals(5, array3[0]);
    Assert.assertEquals(25, array3[1]);
    Assert.assertEquals(25, array3[2]);
    Assert.assertEquals(-1, array3[3]);

    int[] array4 = {13, 7, 6, 12};
    nge = new NextGreaterElement(array4);
    array4 = nge.getNextGreater();
    Assert.assertEquals(-1, array4[0]);
    Assert.assertEquals(12, array4[1]);
    Assert.assertEquals(12, array4[2]);
    Assert.assertEquals(-1, array4[3]);
  }
}
