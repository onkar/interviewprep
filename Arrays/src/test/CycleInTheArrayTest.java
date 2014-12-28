package test;

import main.CycleInTheArray;

import org.junit.Assert;
import org.junit.Test;

public class CycleInTheArrayTest {
  @Test
  public void testDetectCycle() {
    int[] array1 = {-1, 2, 3, 1};
    CycleInTheArray cia = new CycleInTheArray();
    Assert.assertTrue(cia.isCyclic(array1));
    int[] array2 = {3, -2, -3, 0};
    Assert.assertTrue(cia.isCyclic(array2));
    int[] array3 = {-1, 2, 3};
    Assert.assertFalse(cia.isCyclic(array3));
  }

  @Test
  public void testLongestCycle() {
    int[] array1 = {3, 2, 1, 4, 0};
    CycleInTheArray cia = new CycleInTheArray();
    Assert.assertEquals(3, cia.getLongestCycleLength(array1));
    int[] array2 = {3, 2, 1, 0};
    Assert.assertEquals(2, cia.getLongestCycleLength(array2));
  }
}
