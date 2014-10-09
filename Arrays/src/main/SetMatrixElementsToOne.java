package main;

/**
 * Given a boolean matrix mat[M][N] of size M X N, modify it such that if a matrix cell mat[i][j] is
 * 1 (or true) then make all the cells of ith row and jth column as 1.
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class SetMatrixElementsToOne {
  private final int[][] matrix;
  private final int rows, cols;

  public SetMatrixElementsToOne(int[][] matrix, int rows, int cols) {
    this.matrix = matrix;
    this.rows = rows;
    this.cols = cols;
  }

  public void setMatrix() {
    int[] r = new int[rows];
    int[] c = new int[cols];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (matrix[i][j] == 1) {
          r[i] = 1;
          c[j] = 1;
        }
      }
    }

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (r[i] == 1 || c[j] == 1) {
          matrix[i][j] = 1;
        }
      }
    }
  }

}
