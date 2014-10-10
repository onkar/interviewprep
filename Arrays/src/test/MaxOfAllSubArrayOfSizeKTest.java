package test;

import java.util.List;

import junit.framework.Assert;
import main.MaxOfAllSubArraysOfSizeK;

import org.junit.Test;

public class MaxOfAllSubArrayOfSizeKTest {
  private MaxOfAllSubArraysOfSizeK m;

  @Test
  public void test() {
    int[] array = {1, 2, 3, 1, 4, 5, 2, 3, 6};
    m = new MaxOfAllSubArraysOfSizeK(array);
    List<Integer> result = m.getMax(3);
    Assert.assertEquals(7, result.size());
    Assert.assertEquals(3, result.get(0).intValue());
    Assert.assertEquals(3, result.get(1).intValue());
    Assert.assertEquals(4, result.get(2).intValue());
    Assert.assertEquals(5, result.get(3).intValue());
    Assert.assertEquals(5, result.get(4).intValue());
    Assert.assertEquals(5, result.get(5).intValue());
    Assert.assertEquals(6, result.get(6).intValue());

    int[] array2 = {3, 4, 7, 1, 5, 9, 8, 2, 3};
    m = new MaxOfAllSubArraysOfSizeK(array2);
    result = m.getMax(3);
    Assert.assertEquals(7, result.size());
    Assert.assertEquals(7, result.get(0).intValue());
    Assert.assertEquals(7, result.get(1).intValue());
    Assert.assertEquals(7, result.get(2).intValue());
    Assert.assertEquals(9, result.get(3).intValue());
    Assert.assertEquals(9, result.get(4).intValue());
    Assert.assertEquals(9, result.get(5).intValue());
    Assert.assertEquals(8, result.get(6).intValue());
  }

}
