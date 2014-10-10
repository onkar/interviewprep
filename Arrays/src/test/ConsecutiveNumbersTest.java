package test;

import junit.framework.Assert;
import main.ConsecutiveNumbers;

import org.junit.Test;

public class ConsecutiveNumbersTest {
  private ConsecutiveNumbers cn;

  @Test
  public void test() {
    int[] array = {5, 2, 3, 1, 4};
    cn = new ConsecutiveNumbers(array);
    Assert.assertTrue(cn.areConsecutive());

    int[] array2 = {7, 6, 5, 5, 3, 4};
    cn = new ConsecutiveNumbers(array2);
    Assert.assertFalse(cn.areConsecutive());
  }

}
