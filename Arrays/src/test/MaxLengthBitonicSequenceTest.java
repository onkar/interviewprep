package test;

import junit.framework.Assert;
import main.MaxLengthBitonicSequence;

import org.junit.Test;

public class MaxLengthBitonicSequenceTest {
  private MaxLengthBitonicSequence mlbs;

  @Test
  public void test() {
    int[] array = {12, 4, 78, 90, 45, 23};
    mlbs = new MaxLengthBitonicSequence(array);
    Assert.assertEquals(5, mlbs.getSequenceLength());

    int[] array2 = {20, 4, 1, 2, 3, 4, 2, 10};
    mlbs = new MaxLengthBitonicSequence(array2);
    Assert.assertEquals(5, mlbs.getSequenceLength());
  }
}
