package main;

/**
 * Given an integer array, calculate the maximal product subarray. Suppose a[]={3,-4,-5,6,-2}, the
 * maximal product should be 360, i.e., 3 * (-4) * (-5) * 6 = 360.
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 *
 */
public class MaxProductSubarray {

  /**
   * Let max[i] denote maximum product of subarray with a[i] as the last element. Let min[i] denote
   * the minimum product of subarray with a[i] as the last element.
   * 
   * max[i] = max(array[i], max[i - 1] * array[i], min[i - 1] * array[i]) min[i] = min(array[i],
   * max[i - 1] * array[i], min[i - 1] * array[i])
   * 
   * max[0] = min[0] = array[0]
   * 
   * And then we find the maximum element in max array, that is the answer.
   * 
   * @param array
   * @return
   */
  public static int getMaxProduct(int[] array) {
    int[] min = new int[array.length];
    int[] max = new int[array.length];
    max[0] = array[0];
    min[1] = array[0];
    for (int i = 1; i < array.length; i++) {
      max[i] = getMax(array[i], max[i - 1] * array[i], min[i - 1] * array[i]);
      min[i] = getMin(array[i], max[i - 1] * array[i], min[i - 1] * array[i]);
    }
    int result = Integer.MIN_VALUE;
    for (int i = 0; i < max.length; i++) {
      if (max[i] > result)
        result = max[i];
    }
    return result;
  }

  private static int getMin(int i, int j, int k) {
    return Math.min(i, Math.min(j, k));
  }

  private static int getMax(int i, int j, int k) {
    return Math.max(i, Math.max(j, k));
  }

}
