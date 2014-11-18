package test;

import main.Combinations;

import org.junit.Test;

public class CombinationsTest {
  @Test
  public void test() {
    Combinations c = new Combinations("wxyz");
    c.combine();
  }
}
