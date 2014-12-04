package test;

import main.ClimbStairs;

import org.junit.Assert;
import org.junit.Test;

public class ClimbStairsTest {
  @Test
  public void test() {
    ClimbStairs cs = new ClimbStairs();
    Assert.assertEquals(8, cs.numberOfWays(5));
    Assert.assertEquals(8, cs.numberOfWaysDynamic(5));
  }
}
