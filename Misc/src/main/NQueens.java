package main;

public class NQueens {
  public final int N = 8;

  public boolean solveNQueens(int[][] board, int col) {
    if (col >= N)
      return true;
    for (int i = 0; i < N; i++) {
      if (isSafe(board, i, col)) {
        board[i][col] = 1;
        if (solveNQueens(board, col + 1))
          return true;
        board[i][col] = 0;
      }
    }
    return false;
  }

  private boolean isSafe(int[][] board, int row, int col) {
    // For the given column, check all rows
    for (int i = 0; i < N; i++) {
      if (board[i][col] == 1)
        return false;
    }

    // Check right diagonal
    for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
      if (board[i][j] == 1)
        return false;
    }

    // Check left diagonal
    for (int i = row, j = col; i < N && j >= 0; i++, j--) {
      if (board[i][j] == 1)
        return false;
    }

    return true;
  }
}
