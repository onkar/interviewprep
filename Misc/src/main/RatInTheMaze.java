package main;

/**
 * <pre>
 * A Maze is given as N*N binary matrix of blocks where source block is the upper left most block
 * i.e., maze[0][0] and destination block is lower rightmost block i.e., maze[N-1][N-1]. A rat
 * starts from source and has to reach destination. The rat can move only in two directions: forward
 * and down. In the maze matrix, 0 means the block is dead end and 1 means the block can be used in
 * the path from source to destination.
 * 
 * For example, given this maze -
 * {1, 0, 0, 0}
 * {1, 1, 0, 1}
 * {0, 1, 0, 0}
 * {1, 1, 1, 1}
 * 
 * The output should be -
 * {1, 0, 0, 0}
 * {1, 1, 0, 0}
 * {0, 1, 0, 0}
 * {0, 1, 1, 1}
 * 
 * </pre>
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 *
 */
public class RatInTheMaze {
  private int[][] solution;

  public boolean solveMaze(int[][] maze) {
    int rows = maze.length;
    int cols = maze[0].length;
    solution = new int[rows][cols];

    if (!solveMazeUtil(maze, 0, 0)) {
      System.out.println("Solution does not exist");
      return false;
    }
    printSolution();
    return true;
  }

  private void printSolution() {
    for (int i = 0; i < solution[0].length; i++) {
      for (int j = 0; j < solution.length; j++) {
        System.out.print(solution[i][j] + " ");
      }
      System.out.println();
    }
  }

  private boolean solveMazeUtil(int[][] maze, int i, int j) {
    // Termination condition, when index reached the maximum limit of the maze
    if (i == maze[0].length - 1 && j == maze.length - 1) {
      solution[i][j] = 1;
      return true;
    }
    if (isSafe(maze, i, j)) {
      // If maze[i][j] is a valid option, set the index at (i, j) to true in the solution
      solution[i][j] = 1;
      // Try the next subsequent option by incrementing the row and keeping the same column
      if (solveMazeUtil(maze, i + 1, j))
        return true;
      // Try the next subsequent option by incrementing the column and keeping the same row
      if (solveMazeUtil(maze, i, j + 1))
        return true;
      // If you reach here, it means none of the above options worked. This means our choice of
      // (i,j) wasn't the best option. So backtrack by setting (i, j) in the solution to 0 and
      // returning false.
      solution[i][j] = 0;
      return false;
    }
    return false;
  }

  private boolean isSafe(int[][] maze, int i, int j) {
    // If i and j indexes are within the range and maze[i][j] is a valid option for the rat, then
    // it's safe to consider (i, j)
    if (i >= 0 && i < maze[0].length && j >= 0 && j < maze.length && maze[i][j] == 1)
      return true;
    else
      return false;
  }
}
