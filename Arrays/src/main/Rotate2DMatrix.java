package main;

/**
 * Rotate a 2D matrix by 90 degrees clockwise. For rotating 90 degrees counter-clockwise, transpose
 * the matrix and reverse each column.
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class Rotate2DMatrix {
  private final int[][] matrix;
  private final int rows;
  private final int cols;

  public Rotate2DMatrix(int[][] matrix, int rows, int cols) {
    this.matrix = matrix;
    this.rows = rows;
    this.cols = cols;
  }

  public int[][] rotateBy90DegreesClockwise() {
    // Transpose the matrix
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (i < j) {
          int temp = matrix[i][j];
          matrix[i][j] = matrix[j][i];
          matrix[j][i] = temp;
        }
      }
    }

    // Reverse each row
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols / 2; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[i][cols - j - 1];
        matrix[i][cols - j - 1] = temp;
      }
    }
    return matrix;
  }
}
