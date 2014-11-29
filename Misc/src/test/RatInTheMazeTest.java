package test;

import main.RatInTheMaze;

import org.junit.Assert;
import org.junit.Test;

public class RatInTheMazeTest {
  @Test
  public void test() {
    RatInTheMaze ritm = new RatInTheMaze();
    int[][] maze = new int[][] { {1, 0, 0, 0}, //
        {1, 1, 0, 1}, //
        {0, 1, 0, 0}, //
        {1, 1, 1, 1}};
    Assert.assertTrue(ritm.solveMaze(maze));
  }
}
