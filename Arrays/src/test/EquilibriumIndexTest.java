package test;

import junit.framework.Assert;
import main.EquilibriumIndex;

import org.junit.Test;

public class EquilibriumIndexTest {
  private EquilibriumIndex ei;

  @Test
  public void test() {
    int[] array1 = {1, 5, 4, 3, 3};
    ei = new EquilibriumIndex(array1);
    Assert.assertEquals(2, ei.getEquilibriumIndex());

    int[] array2 = {1, 5, 4, 9, 10};
    ei = new EquilibriumIndex(array2);
    Assert.assertEquals(3, ei.getEquilibriumIndex());
  }
}
