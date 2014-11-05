package test;

import main.Prime;

import org.junit.Assert;
import org.junit.Test;

public class PrimeTest {

  @Test
  public void test() {
    Prime p = new Prime();
    Assert.assertTrue(p.isPrime(13));
    boolean[] b = p.sieve(13);
    Assert.assertTrue(b[2]);
    Assert.assertTrue(b[3]);
    Assert.assertTrue(b[5]);
    Assert.assertTrue(b[7]);
    Assert.assertTrue(b[11]);
    Assert.assertTrue(b[13]);
  }
}
