package test;

import main.Fibonacci;

import org.junit.Assert;
import org.junit.Test;

public class FibonacciTest {
  @Test
  public void test() {
    Fibonacci f = new Fibonacci();
    Assert.assertEquals(8, f.fibonacciBetter(6));
    Assert.assertEquals(8, f.fibonacciBad(6));
  }
}
