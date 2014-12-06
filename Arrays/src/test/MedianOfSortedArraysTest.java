package test;

import main.MedianOfSortedArrays;

import org.junit.Test;

public class MedianOfSortedArraysTest {
  @Test
  public void test() {
    int[] a1 = {12, 15, 18, 20};
    int[] a2 = {7, 11, 13, 17, 22};
    MedianOfSortedArrays ms = new MedianOfSortedArrays();
    System.out.println(ms.getMedian(a1, a2));
  }
}
