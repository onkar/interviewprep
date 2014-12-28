package test;

import junit.framework.Assert;
import main.KComplemantary;

import org.junit.Test;

public class KComplemantaryTest {
  @Test
  public void test() {
    int[] array = {1, 5, 9};
    int k = 10;
    KComplemantary kc = new KComplemantary();
    Assert.assertEquals(3, kc.getKComplemantaryPairs(array, k));
  }
}
