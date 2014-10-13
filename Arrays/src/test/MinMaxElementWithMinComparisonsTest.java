package test;

import junit.framework.Assert;
import main.MinMaxElementWithMinComparisons;
import main.MinMaxElementWithMinComparisons.MinMax;

import org.junit.Test;

public class MinMaxElementWithMinComparisonsTest {
  private MinMaxElementWithMinComparisons m;

  @Test
  public void test() {
    int[] array1 = {77, 1, 34, 35, 23, 12, 47, 73, 66};
    m = new MinMaxElementWithMinComparisons(array1);
    MinMax mm = m.findMinMax();
    Assert.assertEquals(1, mm.min);
    Assert.assertEquals(77, mm.max);

    int[] array2 = {98, 345, 33, 2};
    m = new MinMaxElementWithMinComparisons(array2);
    mm = m.findMinMax();
    Assert.assertEquals(2, mm.min);
    Assert.assertEquals(345, mm.max);
  }
}
