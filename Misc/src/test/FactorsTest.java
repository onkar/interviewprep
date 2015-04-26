package test;

import main.Factors;

import org.junit.Test;

public class FactorsTest {
  @Test
  public void test() {
    Factors.printAllSets(12);
    System.out.println("");
    Factors.printAllSets(32);
  }
}
