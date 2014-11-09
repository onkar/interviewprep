package test;

import main.MaxValueContiguousSubsequence;

import org.junit.Assert;
import org.junit.Test;

public class MaxValueContiguousSubsequenceTest {
  @Test
  public void test() {
    int[] array = {-2, -3, 4, -1, -2, 1, 5, -3};
    MaxValueContiguousSubsequence m = new MaxValueContiguousSubsequence();
    Assert.assertEquals(7, m.maxContiguousSum(array));
  }
}
