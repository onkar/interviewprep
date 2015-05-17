package test;

import main.PrimeFactors;

import org.junit.Test;

public class PrimeFactorsTest {
  @Test
  public void test() {
    PrimeFactors.get(12);
    System.out.println();
    PrimeFactors.get(315);
  }
}
