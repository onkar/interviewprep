package test;

import junit.framework.Assert;
import main.SortedRowsColsMatrix;

import org.junit.Test;

public class SortedRowsColsMatrixTest {
  private SortedRowsColsMatrix srcm;

  @Test
  public void test() {
    int[][] matrix = { {34, 35, 36, 37}, {43, 44, 45, 46}, {51, 53, 55, 57}, {64, 66, 68, 70}};
    srcm = new SortedRowsColsMatrix(matrix, 4, 4);
    Assert.assertTrue(srcm.search(53));
    Assert.assertTrue(srcm.search(37));
    Assert.assertFalse(srcm.search(100));
  }
}
