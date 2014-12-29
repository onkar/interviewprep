package test;

import main.MaxProductSubarray;

import org.junit.Assert;
import org.junit.Test;

public class MaxProductSubarrayTest {
  @Test
  public void test() {
    int[] array = {3, -4, -5, 6, -2};
    Assert.assertEquals(360, MaxProductSubarray.getMaxProduct(array));
  }
}
