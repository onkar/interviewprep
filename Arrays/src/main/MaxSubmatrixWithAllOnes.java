package main;

/**
 * Given a matrix containing only 0s and 1s, find a maximum size square sub-matrix with all 1s.
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class MaxSubmatrixWithAllOnes {
  private final int[][] matrix;
  private final int rows;
  private final int cols;

  public static class SubMatrix {
    public int i1, j1;
    public int i2, j2;
  }

  public MaxSubmatrixWithAllOnes(int[][] matrix, int rows, int cols) {
    this.matrix = matrix;
    this.rows = rows;
    this.cols = cols;
  }

  public SubMatrix getSubMatrix() {
    // Create a submatrix array of same size as matrix
    int[][] subMatrix = new int[rows][cols];

    // Copy 0th row and 0th column from matrix to submatrix
    for (int i = 0; i < rows; i++) {
      subMatrix[i][0] = matrix[i][0];
    }
    for (int j = 0; j < cols; j++) {
      subMatrix[0][j] = matrix[0][j];
    }

    /**
     * <pre>
     * If matrix[i][j] is 1 then
     *       subMatrix[i][j] = min(subMatrix[i][j-1], subMatrix[i-1][j], subMatrix[i-1][j-1]) + 1
     *    Else // Meaning when M[i][j] is 0
     *       subMatrix[i][j] = 0
     * </pre>
     */
    for (int i = 1; i < rows; i++) {
      for (int j = 1; j < cols; j++) {
        if (matrix[i][j] == 1) {
          subMatrix[i][j] =
              min(subMatrix[i - 1][j], subMatrix[i][j - 1], subMatrix[i - 1][j - 1]) + 1;
        } else {
          subMatrix[i][j] = 0;
        }
      }
    }

    // Find the index of maximum element in subMatrix
    int max = Integer.MIN_VALUE;
    int maxI = 0, maxJ = 0;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (subMatrix[i][j] > max) {
          max = subMatrix[i][j];
          maxI = i;
          maxJ = j;
        }
      }
    }

    // Calculate the starting and ending indices of the submatrix and return
    SubMatrix sb = new SubMatrix();
    sb.i2 = maxI;
    sb.j2 = maxJ;
    sb.i1 = maxI - (subMatrix[maxI][maxJ] - 1);
    sb.j1 = maxJ - (subMatrix[maxI][maxJ] - 1);
    return sb;
  }

  // Find minimum number from three given numbers
  private int min(int i, int j, int k) {
    int min = i;
    if (min > j) {
      min = j;
    }
    if (min > k) {
      min = k;
    }
    return min;
  }
}
