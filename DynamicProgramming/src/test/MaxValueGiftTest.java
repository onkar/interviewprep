package test;

import junit.framework.Assert;
import main.MaxValueGift;

import org.junit.Test;

public class MaxValueGiftTest {

  @Test
  public void test() {
    MaxValueGift mvg = new MaxValueGift();
    int[][] gift = { {1, 10, 3, 8}, {12, 2, 9, 6}, {5, 7, 4, 11}, {3, 7, 16, 5}};
    Assert.assertEquals(53, mvg.getMaxValue(gift));
  }
}
