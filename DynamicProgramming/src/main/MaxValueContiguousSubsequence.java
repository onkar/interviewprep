package main;

/**
 * Max contiguous subsequnce is a subsequence between i and j of array A[1, n] s.t. the sum between
 * i and j indexes is max.
 * 
 * <pre>
 * So, if M(i) -> max sum over all windows ending at j then, 
 * M(i) = Max(M(i - 1) + A[i], A[i])
 * </pre>
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 *
 */
public class MaxValueContiguousSubsequence {
  public int maxContiguousSum(int[] array) {
    int maxSoFar = array[0];
    int currentMax = array[0];
    for (int i = 1; i < array.length; i++) {
      currentMax = Math.max(array[i], currentMax + array[i]);
      maxSoFar = Math.max(currentMax, maxSoFar);
    }
    return maxSoFar;
  }
}
