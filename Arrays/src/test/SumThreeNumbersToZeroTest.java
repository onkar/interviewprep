package test;

import main.SumThreeNumbersToZero;

import org.junit.Test;

public class SumThreeNumbersToZeroTest {
  @Test
  public void test() {
    int[] array = {-3, 5, -1, -2, 4, 3};
    SumThreeNumbersToZero sz = new SumThreeNumbersToZero();
    sz.findThreeNumSumToZero(array);
  }
}
