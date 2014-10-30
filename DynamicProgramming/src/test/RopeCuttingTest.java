package test;

import main.RopeCutting;

import org.junit.Assert;
import org.junit.Test;

public class RopeCuttingTest {
  @Test
  public void test() {
    RopeCutting rc = new RopeCutting();
    Assert.assertEquals(6, rc.maxProduct(5));
    Assert.assertEquals(6, rc.maxProdBetter(5));
    Assert.assertEquals(6, rc.maxProdBest(5));
  }
}
