package test;

import java.util.List;

import junit.framework.Assert;
import main.KClosestElements;

import org.junit.Test;

public class KClosestElementsTest {
  private final int[] arr = {12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56};
  private final int k = 4;
  private final int x = 35;

  @Test
  public void testKClosestElements() {
    KClosestElements kce = new KClosestElements(arr, arr.length, x, k);
    List<Integer> results = kce.findKClosest();
    Assert.assertEquals(k, results.size());
    Assert.assertTrue(results.contains(30));
    Assert.assertTrue(results.contains(39));
    Assert.assertTrue(results.contains(42));
    Assert.assertTrue(results.contains(45));
  }
}
