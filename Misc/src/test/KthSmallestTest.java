package test;

import junit.framework.Assert;
import main.KthSmallest;

import org.junit.Test;

public class KthSmallestTest {
  @Test
  public void test() {
    KthSmallest ks = new KthSmallest();
    int[] array = {13, 9, 3, 2, 11, 7, 5};
    Assert.assertEquals(7, ks.getKthSmallest(array, 3));
  }
}
