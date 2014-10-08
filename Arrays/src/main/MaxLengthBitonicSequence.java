package main;

/**
 * Given an array A[0 ... n-1] containing n positive integers, a subarray A[i ... j] is bitonic if
 * there is a k with i <= k <= j such that A[i] <= A[i + 1] ... <= A[k] >= A[k + 1] >= .. A[j - 1] >
 * = A[j]. Write a function that takes an array as argument and returns the length of the maximum
 * length bitonic subarray.
 * 
 * Simple Examples 1) A[] = {12, 4, 78, 90, 45, 23}, the maximum length bitonic subarray is {4, 78,
 * 90, 45, 23} which is of length 5.
 * 
 * 2) A[] = {20, 4, 1, 2, 3, 4, 2, 10}, the maximum length bitonic subarray is {1, 2, 3, 4, 2} which
 * is of length 5.
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class MaxLengthBitonicSequence {
  private final int[] array;

  public MaxLengthBitonicSequence(int[] array) {
    this.array = array;
  }

  public int getSequenceLength() {
    int[] inc = new int[array.length];
    int[] dec = new int[array.length];
    for (int i = 0; i < array.length; i++) {
      inc[i] = 1;
      dec[i] = 1;
    }
    for (int i = 0; i < array.length - 1; i++) {
      if (array[i] < array[i + 1]) {
        inc[i + 1] = inc[i] + 1;
      }
    }
    for (int i = array.length - 1; i >= 1; i--) {
      if (array[i] < array[i - 1]) {
        dec[i - 1] = dec[i] + 1;
      }
    }

    return getMax(inc, dec);
  }

  private int getMax(int[] a, int[] b) {
    int max = a[0] + b[0] - 1;
    for (int i = 1; i < array.length; i++) {
      if (a[i] + b[i] - 1 > max) {
        max = a[i] + b[i] - 1;
      }
    }
    return max;
  }

}
