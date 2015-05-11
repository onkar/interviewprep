package test;

import main.BigInt;

import org.junit.Assert;
import org.junit.Test;

public class BigIntTest {
  @Test
  public void test() {
    String num1 = "1234";
    String num2 = "123";
    Assert.assertEquals("151782", BigInt.multiply(num1, num2));
    Assert.assertEquals("151782", BigInt.multiply(num2, num1));
  }
}
