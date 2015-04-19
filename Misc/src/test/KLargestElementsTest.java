package test;

import main.KLargestElements;

import org.junit.Assert;
import org.junit.Test;

public class KLargestElementsTest {
  @Test
  public void test() {
    int[] array1 = {13, 9, 3, 2, 11, 7, 5};
    int[] result = KLargestElements.get(array1, 3);
    Assert.assertEquals(13, result[0]);
    Assert.assertEquals(9, result[1]);
    Assert.assertEquals(11, result[2]);
  }
}
