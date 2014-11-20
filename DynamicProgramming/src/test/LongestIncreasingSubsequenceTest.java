package test;

import main.LongestIncreasingSubsequence;

import org.junit.Assert;
import org.junit.Test;

public class LongestIncreasingSubsequenceTest {
  @Test
  public void test() {
    LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
    int[] array = {10, 22, 9, 33, 21, 50, 41, 60, 80};
    Assert.assertEquals(6, lis.getLISLength(array));
  }
}
