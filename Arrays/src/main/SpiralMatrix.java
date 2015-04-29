package main;

// Time complexity is O(m * n) where m = no. of rows, n = no. of columns
public class SpiralMatrix {
  public static void printSpiral(int[][] matrix) {
    if (matrix.length == 0)
      return;

    int top = 0;
    int bottom = matrix.length - 1;
    int left = 0;
    int right = matrix[0].length - 1;

    while (true) {
      // Top row
      for (int j = left; j <= right; j++)
        System.out.print(matrix[top][j] + " ");
      ++top;
      if (shouldExit(top, bottom, left, right) == true)
        break;

      // Right column
      for (int i = top; i <= bottom; i++)
        System.out.print(matrix[i][right] + " ");
      --right;
      if (shouldExit(top, bottom, left, right) == true)
        break;

      // Bottom row
      for (int j = right; j >= left; j--)
        System.out.print(matrix[bottom][j] + " ");
      --bottom;
      if (shouldExit(top, bottom, left, right) == true)
        break;

      // Left column
      for (int i = bottom; i >= top; i--)
        System.out.print(matrix[i][left] + " ");
      ++left;
      if (shouldExit(top, bottom, left, right) == true)
        break;
    }
  }

  private static boolean shouldExit(int top, int bottom, int left, int right) {
    return top > bottom || left > right;
  }
}
