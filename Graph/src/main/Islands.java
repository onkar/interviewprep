package main;

/**
 * Find islands in given graph. A group of connected 1s forms an island. For example, the below
 * matrix contains 5 islands
 * 
 * <pre>
 * {1, 1, 0, 0, 0},
 * {0, 1, 0, 0, 1},
 * {1, 0, 0, 1, 1},
 * {0, 0, 0, 0, 0},
 * {1, 0, 1, 0, 1}
 * </pre>
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 *
 */
public class Islands {
  public static int getCount(int[][] graph) {
    // Initialize visited matrix
    boolean[][] visited = new boolean[graph.length][graph[0].length];
    int count = 0;
    for (int i = 0; i < graph.length; i++) {
      for (int j = 0; j < graph[0].length; j++) {
        // If a cell if found to be 1 and it is not already visited, do a DFS
        if (graph[i][j] == 1 && !visited[i][j]) {
          dfs(graph, i, j, visited);
          // For every DFS, increment a counter. This counter will denote the number of islands.
          count++;
        }
      }
    }
    return count;
  }

  private static void dfs(int[][] graph, int rowIndex, int colIndex, boolean[][] visited) {
    // Create two arrays denoting increments / decrements to get next row and column
    int[] rowNums = {-1, -1, 1, 0, 1, 1, 1, 0};
    int[] colsNums = {-1, 0, 1, 1, 1, 0, -1, -1};

    // Update visited matrix
    visited[rowIndex][colIndex] = true;

    // We need to check in all 8 directions
    for (int k = 0; k < 8; k++) {
      if (isSafe(graph, rowIndex + rowNums[k], colIndex + colsNums[k], visited)) {
        dfs(graph, rowIndex + rowNums[k], colIndex + colsNums[k], visited);
      }
    }
  }

  private static boolean isSafe(int[][] graph, int i, int j, boolean[][] visited) {
    // When indexes are within the bounds and cell at that index is 1 and it's not already visited,
    // return true.
    if (i >= 0 && i < graph.length && j >= 0 && j < graph[0].length && graph[i][j] == 1
        && !visited[i][j])
      return true;
    else
      return false;
  }
}
