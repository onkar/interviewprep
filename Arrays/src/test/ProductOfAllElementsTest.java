package test;

import junit.framework.Assert;
import main.ProductOfAllElements;

import org.junit.Test;

public class ProductOfAllElementsTest {
  private ProductOfAllElements pae;

  @Test
  public void test() {
    int[] array = {1, 2, 3, 4, 5};
    pae = new ProductOfAllElements(array);
    array = pae.getProduct();
    Assert.assertEquals(120, array[0]);
    Assert.assertEquals(60, array[1]);
    Assert.assertEquals(40, array[2]);
    Assert.assertEquals(30, array[3]);
    Assert.assertEquals(24, array[4]);
  }
}
