package test;

import junit.framework.Assert;
import main.HouseColoring;

import org.junit.Test;

public class HouseColoringTest {
  private HouseColoring hc;

  @Test
  public void test() {
    int[][] costMatrix = { {7, 5, 10}, {3, 6, 1}, {8, 7, 4}, {6, 2, 9}, {1, 4, 7}, {2, 3, 6},};
    hc = new HouseColoring(costMatrix);
    Assert.assertEquals(18, hc.houseColoringCost());
  }
}
