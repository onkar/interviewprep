package test;

import main.WordInGrid;

import org.junit.Assert;
import org.junit.Test;

public class WordInGridTest {
  @Test
  public void test() {
    char[][] grid1 = { //
        {'t', 'o', 'p', 't'}, //
            {'g', 'f', 'c', 'q'}, //
            {'t', 'y', 'o', 'd'}, //
            {'d', 'f', 'r', 'e'}};
    Assert.assertTrue(WordInGrid.find(grid1, "topcoder"));
    char[][] grid2 = { //
        {'A', 'C', 'P', 'R', 'C'}, //
            {'X', 'S', 'O', 'P', 'C'}, //
            {'V', 'O', 'V', 'N', 'I'}, //
            {'W', 'G', 'F', 'M', 'N'}, //
            {'Q', 'A', 'T', 'I', 'T'}};
    Assert.assertTrue(WordInGrid.find(grid2, "MICROSOFT"));
  }
}
