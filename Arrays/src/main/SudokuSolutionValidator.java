package main;

import java.util.BitSet;

/**
 * Check if given Sudoku solution is valid or not.
 * 
 * <pre>
 * 
 * Rules -
 * 1. Grid size is 9 x 9, divided into 9 regions of 3 x 3 size
 * 2. Each row must contain all digits from 1 to 9
 * 3. Each column must contain all digits from 1 to 9
 * 4. Each 3 x 3 region must contain all digits from 1 to 9
 * 
 * </pre>
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 *
 */
public class SudokuSolutionValidator {
  public static boolean isValid(int[][] board) {
    int rows = board.length;
    int cols = board[0].length;

    // Check if each row and column in the board satisfy Sudoku requirement
    for (int i = 0; i < rows; i++) {
      BitSet rowBits = new BitSet(rows);
      BitSet columnBits = new BitSet(cols);
      for (int j = 0; j < cols; j++) {
        if (board[i][j] < 1 || board[i][j] > 9) {
          return false;
        }
        if (rowBits.get(board[i][j] - 1) || columnBits.get(board[j][i] - 1))
          return false;
        else {
          rowBits.set(board[i][j] - 1);
          columnBits.set(board[j][i] - 1);
        }
      }
    }

    // Check 3 x 3 smaller boards
    for (int rowOffset = 0; rowOffset < rows; rowOffset += 3) {
      for (int columnOffset = 0; columnOffset < cols; columnOffset += 3) {
        BitSet smallerMatrix = new BitSet(rows);
        for (int i = rowOffset; i < rowOffset + 3; i++) {
          for (int j = columnOffset; j < columnOffset + 3; j++) {
            if (board[i][j] < 1 || board[i][j] > 9)
              return false;
            if (smallerMatrix.get(board[i][j] - 1))
              return false;
            else
              smallerMatrix.set(board[i][j] - 1);
          }
        }
      }
    }

    return true;
  }
}
