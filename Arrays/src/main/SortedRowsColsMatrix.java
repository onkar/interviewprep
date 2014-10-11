package main;

/**
 * Search a number in a row and column wise sorted matrix
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class SortedRowsColsMatrix {
  private final int[][] matrix;
  private final int rows;
  private final int cols;

  public SortedRowsColsMatrix(int[][] matrix, int rows, int cols) {
    this.matrix = matrix;
    this.rows = rows;
    this.cols = cols;
  }

  public boolean search(int element) {
    int i = 0, j = cols - 1;
    while (i < rows && j >= 0) {
      // Start from the last element in first row and do binary search
      if (matrix[i][j] == element) {
        // If matched, return true
        return true;
      } else if (matrix[i][j] > element) {
        // If that element is greater, then reduce the column
        j--;
      } else {
        // If that element is smaller, increase the row
        i++;
      }
    }
    // Not found, return false
    return false;
  }
}
