package test;

import main.SudokuSolutionValidator;

import org.junit.Assert;
import org.junit.Test;

public class SudokuSolutionValidatorTest {
  @Test
  public void test() {
    int[][] validBoard = //
        { {1, 7, 5, 8, 3, 9, 4, 2, 6}, //
            {6, 3, 8, 2, 7, 4, 9, 1, 5}, //
            {4, 2, 9, 6, 5, 1, 3, 7, 8}, //
            {8, 1, 6, 3, 9, 5, 7, 4, 2}, //
            {5, 4, 7, 1, 6, 2, 8, 3, 9}, //
            {2, 9, 3, 4, 8, 7, 6, 5, 1}, //
            {7, 5, 4, 9, 2, 6, 1, 8, 3}, //
            {9, 8, 1, 5, 4, 3, 2, 6, 7}, //
            {3, 6, 2, 7, 1, 8, 5, 9, 4} //
        };
    Assert.assertTrue(SudokuSolutionValidator.isValid(validBoard));

    int[][] invalidBoard = //
        { {1, 7, 5, 8, 3, 9, 4, 2, 6}, //
            {6, 3, 8, 2, 7, 4, 9, 1, 5}, //
            {4, 2, 9, 6, 5, 7, 3, 7, 8}, //
            {8, 1, 6, 3, 9, 5, 7, 4, 2}, //
            {5, 4, 7, 1, 6, 2, 8, 3, 9}, //
            {2, 9, 3, 8, 8, 7, 6, 5, 1}, //
            {7, 5, 4, 19, 2, 6, 1, 8, 3}, //
            {9, 8, 1, 5, 4, 3, 2, 6, 7}, //
            {3, 6, 2, 7, 1, 8, 5, 9, 4} //
        };
    Assert.assertFalse(SudokuSolutionValidator.isValid(invalidBoard));
  }
}
