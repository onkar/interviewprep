package test;

import main.Power;

import org.junit.Assert;
import org.junit.Test;

public class PowerTest {
  @Test
  public void test() {
    Assert.assertEquals(81, Power.get(3, 4));
    Assert.assertEquals(81, Power.getOptimized(3, 4), 1e7);
    Assert.assertEquals(81, Power.getOptimizedNegative(3, -4), 1e7);
    Assert.assertEquals(0.125, Power.getOptimizedNegative(2, -3), 1e7);
  }
}
