package main;

public class WordInGrid {

  public static boolean find(char[][] grid, String pattern) {
    int rows = grid.length;
    int cols = grid[0].length;
    // When a character is used, corresponding row and column index is set in used matrix. This is
    // done to avoid using the same character again.
    boolean[][] used = new boolean[rows][cols];
    return findNeigbors(grid, 0, 0, pattern, 0, used);
  }

  private static boolean findNeigbors(char[][] grid, int rowIndex, int colIndex, String pattern,
      int index, boolean[][] used) {
    // Base case. When pattern is successfully processed, return true
    if (index == pattern.length()) {
      return true;
    }

    if (!areValidIndexes(grid, rowIndex, colIndex)) {
      return false;
    }

    // Cannot reuse the same character again
    if (used[rowIndex][colIndex] == true)
      return false;

    // This if block is used only for first character matching. We check in all 8 directions only if
    // the first character is matched.
    if (grid[rowIndex][colIndex] != pattern.charAt(index) && index == 0) {
      if (colIndex != grid[0].length - 1)
        // Increment column index keeping the same row index
        return findNeigbors(grid, rowIndex, colIndex + 1, pattern, index, used);
      else if (rowIndex != grid.length - 1)
        // Increment row index while keeping 0 as the column index
        return findNeigbors(grid, rowIndex + 1, 0, pattern, index, used);
      else
        // First character is not matched, no point in searching rest of the string.
        return false;
    }

    if (grid[rowIndex][colIndex] == pattern.charAt(index)) {
      // Update used matrix
      used[rowIndex][colIndex] = true;
      // Check in all 8 directions
      boolean result =
          findNeigbors(grid, rowIndex - 1, colIndex - 1, pattern, index + 1, used)
              || findNeigbors(grid, rowIndex - 1, colIndex, pattern, index + 1, used)
              || findNeigbors(grid, rowIndex - 1, colIndex + 1, pattern, index + 1, used)
              || findNeigbors(grid, rowIndex, colIndex + 1, pattern, index + 1, used)
              || findNeigbors(grid, rowIndex + 1, colIndex + 1, pattern, index + 1, used)
              || findNeigbors(grid, rowIndex + 1, colIndex, pattern, index + 1, used)
              || findNeigbors(grid, rowIndex + 1, colIndex - 1, pattern, index + 1, used)
              || findNeigbors(grid, rowIndex, colIndex - 1, pattern, index + 1, used);
      // If you reached here, choice of rowIndex and colIndex was bad. Set it to false and
      // backtrack.
      used[rowIndex][colIndex] = false;
      return result;
    } else {
      return false;
    }

  }

  private static boolean areValidIndexes(char[][] grid, int rowIndex, int colIndex) {
    if (rowIndex >= 0 && rowIndex < grid.length && colIndex >= 0 && colIndex < grid[0].length)
      return true;
    else
      return false;
  }

}
