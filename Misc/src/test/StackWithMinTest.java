package test;

import static org.junit.Assert.fail;
import main.StackWithMin;

import org.junit.Assert;
import org.junit.Test;

public class StackWithMinTest {
  @Test
  public void test() {
    StackWithMin s = new StackWithMin();
    s.push(3);
    s.push(2);
    s.push(4);
    Assert.assertEquals(2, s.min());
    s.push(1);
    Assert.assertEquals(1, s.min());
    Assert.assertEquals(1, s.pop());
    Assert.assertEquals(2, s.min());
    Assert.assertEquals(4, s.pop());
    Assert.assertEquals(2, s.min());
    Assert.assertEquals(2, s.pop());
    Assert.assertEquals(3, s.min());
    Assert.assertEquals(3, s.pop());
    try {
      s.pop();
      fail("Should have failed");
    } catch (IllegalStateException is) {
      // Ok, expected to get this exception since we called pop() on an empty stack
    }
  }
}
