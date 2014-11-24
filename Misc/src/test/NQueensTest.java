package test;

import main.NQueens;

import org.junit.Assert;
import org.junit.Test;

public class NQueensTest {
  @Test
  public void test() {
    int[][] board = { {0, 0, 0, 0, 0, 0, 0, 0}, //
        {1, 0, 0, 0, 0, 0, 0, 0}, //
        {0, 0, 0, 0, 0, 0, 0, 0}, //
        {0, 0, 0, 0, 0, 0, 0, 0}, //
        {0, 0, 0, 0, 0, 0, 0, 0}, //
        {0, 0, 0, 0, 0, 0, 0, 0}, //
        {0, 0, 0, 0, 0, 0, 0, 0}, //
        {0, 0, 0, 0, 0, 0, 0, 0} //
        };
    NQueens nq = new NQueens();
    Assert.assertFalse(nq.solveNQueens(board, 0));
    Assert.assertTrue(nq.solveNQueens(board, 3));
  }
}
