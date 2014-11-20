package test;

import main.PowerSet;

import org.junit.Test;

public class PowerSetTest {
  @Test
  public void test() {
    PowerSet ps = new PowerSet();
    int[] array = {1, 2, 3};
    ps.printPowerSet(array);
  }
}
