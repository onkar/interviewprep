package test;

import main.Islands;

import org.junit.Assert;
import org.junit.Test;

public class IslandsTest {
  @Test
  public void test() {
    int[][] graph = { {1, 1, 0, 0, 0}, //
        {0, 1, 0, 0, 1}, //
        {1, 0, 0, 1, 1}, //
        {0, 0, 0, 0, 0}, //
        {1, 0, 1, 0, 1}};
    Assert.assertEquals(5, Islands.getCount(graph));
  }
}
