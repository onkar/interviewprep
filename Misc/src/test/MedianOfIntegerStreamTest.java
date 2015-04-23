package test;

import main.MedianOfIntegerStream;

import org.junit.Assert;
import org.junit.Test;

public class MedianOfIntegerStreamTest {
  private static final double DELTA = 1e-15;

  @Test
  public void test() {
    MedianOfIntegerStream mis1 = new MedianOfIntegerStream();
    mis1.addElements(17);
    mis1.addElements(1);
    mis1.addElements(44);
    mis1.addElements(15);
    mis1.addElements(9);
    mis1.addElements(50);
    Assert.assertEquals(16.0, mis1.getMedian(), DELTA);
    mis1.addElements(55);
    Assert.assertEquals(17.0, mis1.getMedian(), DELTA);
  }
}
