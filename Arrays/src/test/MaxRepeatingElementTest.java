package test;

import junit.framework.Assert;
import main.MaxRepeatingElement;

import org.junit.Test;

public class MaxRepeatingElementTest {
  private final int array[] = {1, 2, 1, 4, 2, 2, 5, 4};

  @Test
  public void test() {
    MaxRepeatingElement mre = new MaxRepeatingElement(array, array.length, 5);
    Assert.assertEquals(2, mre.getMaxRepeating());
    Assert.assertEquals(2, mre.getMaxRepeatingUsingHashMap());
  }

}
