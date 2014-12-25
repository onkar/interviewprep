package test;


import main.BoxStacking;
import main.BoxStacking.Box;

import org.junit.Assert;
import org.junit.Test;

public class BoxStackingTest {
  @Test
  public void test() {
    Box[] boxes = {new Box(4, 6, 7), new Box(1, 2, 3), new Box(4, 5, 6), new Box(10, 12, 32)};
    BoxStacking bs = new BoxStacking();
    Assert.assertEquals(60, bs.maxStackHeight(boxes));
  }
}
