package test;

import main.SumOfMultiples;

import org.junit.Assert;
import org.junit.Test;

public class SumOfMultiplesTest {
  @Test
  public void test() {
    Assert.assertEquals(233168, SumOfMultiples.getSum(1000));
  }
}
