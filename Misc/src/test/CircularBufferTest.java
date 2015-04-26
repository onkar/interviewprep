package test;

import main.CircularBuffer;

import org.junit.Assert;
import org.junit.Test;

public class CircularBufferTest {
  @Test
  public void test() {
    CircularBuffer cb = new CircularBuffer(5);
    for (int i = 1; i <= 5; i++)
      cb.add(i);
    try {
      cb.add(100);
      Assert.fail("Should have got exception");
    } catch (IllegalStateException ise) {
      Assert.assertEquals("Queue is full", ise.getMessage());
    }
    for (int i = 1; i <= 5; i++) {
      Assert.assertEquals(i, cb.remove());
    }
    try {
      cb.remove();
      Assert.fail("Should have got exception");
    } catch (IllegalStateException ise) {
      Assert.assertEquals("Queue is empty", ise.getMessage());
    }
  }
}
