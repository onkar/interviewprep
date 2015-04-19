package main;

import java.util.BitSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Please write the following function:
 * 
 * is_valid_solution(string grid) => boolean
 * 
 * The input, grid, is a string representing a grid starting in the top-left corner and moving
 * row-by-row down to the bottom-right. For instance, the grid pictured above would be:
 * 
 * grid = "835416927296857431417293658569134782123678549748529163652781394981345276374962815"
 * 
 * The output is a boolean representing whether it is a valid solution.
 * 
 * Three things before starting:
 * 
 * 1. Use the language you are most comfortable programming in. It does not matter what language
 * this is, other than that it should be a real language (i.e., not pseudo-code).
 * 
 * 2. Do not throw an exception. Return true if the grid is valid and false under all other
 * circumstances. Assume nothing about grid. It might not be an 81 character string. It could be
 * null, an integer, the string "hello" or anything else that would compile in the language of your
 * choice. Again, if so, just return false.
 * 
 * 3. Do not worry about performance. Optimize for *clarity*. Ideally, another programmer could look
 * at your code and quickly and easily understand how it works. You do not need comments or tests.
 * Feel free to have them if they help you write correct, clear code, but only the code itself will
 * be assessed.
 * 
 * Thanks for your interest in Mixpanel. Good luck!
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 *
 */
public class SudokuValidator {

  public static int SUDOKU_ROWS = 9;
  public static int SUDOKU_COLS = 9;

  public static boolean isValidSolution(String grid) {
    if (grid == null)
      return false;

    if (grid.length() < SUDOKU_ROWS * SUDOKU_COLS)
      return false;

    Pattern pattern = Pattern.compile("\\s");
    Matcher matcher = pattern.matcher(grid);
    if (matcher.find())
      return false;

    for (int i = 0; i < grid.length(); i++) {
      if (!Character.isDigit(grid.charAt(i))) {
        return false;
      }
    }

    int[][] matrix = new int[SUDOKU_ROWS][SUDOKU_COLS];
    for (int i = 0; i < SUDOKU_ROWS; i++) {
      for (int j = 0; j < SUDOKU_COLS; j++) {
        matrix[i][j] = Character.getNumericValue(grid.charAt(i * SUDOKU_COLS + j));
      }
    }
    return isValid(matrix);
  }

  private static boolean isValid(int[][] matrix) {
    // Check if each row and column in the matrix satisfy Sudoku requirement
    for (int i = 0; i < SUDOKU_ROWS; i++) {
      BitSet rowBits = new BitSet(SUDOKU_ROWS);
      BitSet columnBits = new BitSet(SUDOKU_COLS);
      for (int j = 0; j < SUDOKU_COLS; j++) {
        if (matrix[i][j] < 1) {
          return false;
        }
        if (rowBits.get(matrix[i][j] - 1) || columnBits.get(matrix[j][i] - 1))
          return false;
        else {
          rowBits.set(matrix[i][j] - 1);
          columnBits.set(matrix[j][i] - 1);
        }
      }
    }

    // Check 3 x 3 smaller matrices
    for (int rowOffset = 0; rowOffset < SUDOKU_ROWS; rowOffset += 3) {
      for (int columnOffset = 0; columnOffset < SUDOKU_COLS; columnOffset += 3) {
        BitSet smallerMatrix = new BitSet(SUDOKU_ROWS);
        for (int i = rowOffset; i < rowOffset + 3; i++) {
          for (int j = columnOffset; j < columnOffset + 3; j++) {
            if (matrix[i][j] < 1)
              return false;
            if (smallerMatrix.get(matrix[i][j] - 1))
              return false;
            else
              smallerMatrix.set(matrix[i][j] - 1);
          }
        }
      }
    }

    return true;
  }

}
