package test;

import junit.framework.Assert;
import main.NumberMatchingIndex;

import org.junit.Test;

public class NumberMatchingIndexTest {

  @Test
  public void test() {
    int[] array = {-5, -3, -1, 2, 4, 7, 11};
    NumberMatchingIndex nmi = new NumberMatchingIndex(array);
    Assert.assertEquals(4, nmi.findNumberMatchingIndex());
    Assert.assertEquals(4, nmi.findNumberMatchingIndexIterative());
    int[] array2 = {1, 2, 3, 4, 5};
    nmi = new NumberMatchingIndex(array2);
    Assert.assertEquals(-1, nmi.findNumberMatchingIndex());
    Assert.assertEquals(-1, nmi.findNumberMatchingIndexIterative());

    int[] array3 = {-10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13};
    nmi = new NumberMatchingIndex(array3);
    Assert.assertEquals(2, nmi.findNumberMatchingIndexNonDistinct());
  }
}
