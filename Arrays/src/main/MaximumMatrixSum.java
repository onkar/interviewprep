package main;

import main.MaxiumSumSubArray.Result;

/**
 * <pre>
 * Find the maximum sum matrix in a given matrix. The logic is to fix a column 0, and then increase
 * it one by one and update maxSum. Each time when a new column is selected, add into the previous
 * values of the column.
 * 
 * Time complexity : O(n^3) if it's a square matrix of size n x n 
 * Space complexity : O(n^2) if it's a square matrix of size n x n
 * </pre>
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class MaximumMatrixSum {
  private final int[][] matrix;
  private final int rows;
  private final int cols;

  public static class MaxSumMatrix {
    public int left;
    public int right;
    public int top;
    public int bottom;
    public int maxSum;
  }

  public MaximumMatrixSum(int[][] matrix, int rows, int cols) {
    this.matrix = matrix;
    this.rows = rows;
    this.cols = cols;
  }

  public MaxSumMatrix getMaxSum() {
    int[] temp;
    MaxSumMatrix msm = new MaxSumMatrix();
    for (int left = 0; left < cols; left++) {
      // Allocate the temp array
      temp = new int[rows];

      for (int right = left; right < cols; right++) {
        // Add to the previous values in temp array
        for (int i = 0; i < rows; i++) {
          temp[i] += matrix[i][right];
        }

        // Get the top and bottom values (i, j indices) from Kadane's algorithm
        MaxiumSumSubArray ms = new MaxiumSumSubArray(temp, temp.length);
        Result r = ms.getMaxSumSubArray();

        // Update the maximum sum and the matrix boundries containing this sum
        if (r.sum > msm.maxSum) {
          msm.maxSum = r.sum;
          msm.left = left;
          msm.right = right;
          msm.top = r.i;
          msm.bottom = r.j;
        }
      }
    }
    return msm;
  }
}
