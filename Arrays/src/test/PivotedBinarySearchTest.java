package test;

import junit.framework.Assert;
import main.PivotedBinarySearch;

import org.junit.Test;

public class PivotedBinarySearchTest {
  private PivotedBinarySearch pbs;

  @Test
  public void test() {
    int[] array = {8, 9, 10, 20, 22, 1, 4, 5, 7};
    pbs = new PivotedBinarySearch(array);
    Assert.assertEquals(6, pbs.search(4));
    Assert.assertEquals(0, pbs.search(8));
    Assert.assertEquals(-1, pbs.search(12));
  }
}
