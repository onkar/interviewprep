package test;

import junit.framework.Assert;
import main.StackWithMin;

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
    s.pop();
    Assert.assertEquals(2, s.min());
  }
}
