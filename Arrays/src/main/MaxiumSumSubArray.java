package main;

/**
 * Maximum sum subarray problem (Kadane's algorithm)
 * 
 * <pre>
 * Input = [-1, -2, 3, 4, -5, 6]
 * Output = 8 (from index 2 through 5)
 * 
 * Source : http://www.youtube.com/watch?v=epTQfFlhQBo&list=UU8-voOePxRpjeOvJleYSV5w
 * </pre>
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class MaxiumSumSubArray {
  private final int[] array;
  private final int size;

  public static class Result {
    public int i; // Starting index of the maximum sum
    public int j; // Ending index of the maximum sum
    public int sum; // Maximum sum
  }

  public MaxiumSumSubArray(int[] array, int size) {
    this.array = array;
    this.size = size;
  }

  public Result getMaxSumSubArray() {
    Result maxCurrentSum = new Result();
    // Initialize maximum current sum to negative infinity
    maxCurrentSum.sum = -1 * Integer.MAX_VALUE;

    Result max = new Result();
    // Initialize maximum to be negative infinity
    max.sum = -1 * Integer.MAX_VALUE;

    // maxSubArray is used to track the starting index, ending index and maximum sum of the result
    Result[] maxSubArray = new Result[size];

    for (int i = 0; i < size; i++) {
      if (maxCurrentSum.sum < 0) {
        // If the sum we have calculated so far is negative, then throw away that sum and start
        // fresh from the current array[i]. Also update starting index and ending index
        maxCurrentSum.sum = array[i];
        maxCurrentSum.i = i;
        maxCurrentSum.j = i;
      } else {
        // If the sum we gathered so far is positive, then add the current array[i] (even if
        // array[i] is negative) and update the ending index
        maxCurrentSum.sum += array[i];
        maxCurrentSum.j = i;
      }
      if (maxCurrentSum.sum > max.sum) {
        // Update the maximum current sum
        max.sum = maxCurrentSum.sum;
        max.i = maxCurrentSum.i;
        max.j = maxCurrentSum.j;
      }
      // Update the array with the maximum value
      maxSubArray[i] = max;
    }
    // Final result will be the element at n-1th index
    return maxSubArray[size - 1];
  }

}
