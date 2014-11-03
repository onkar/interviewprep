package test;


import main.MinCoinsForChange;

import org.junit.Assert;
import org.junit.Test;

public class MinCoinsForChangeTest {
  @Test
  public void test() {
    int[] coins = {1, 3, 5};
    MinCoinsForChange mcfc = new MinCoinsForChange();
    Assert.assertEquals(3, mcfc.getMinCoins(coins, 11));
  }
}
