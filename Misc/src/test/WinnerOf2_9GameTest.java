package test;

import main.WinnerOf2_9Game;

import org.junit.Assert;
import org.junit.Test;

public class WinnerOf2_9GameTest {
  @Test
  public void test() {
    WinnerOf2_9Game wg = new WinnerOf2_9Game();
    Assert.assertEquals(1, wg.getWhoWins(3));
    Assert.assertEquals(2, wg.getWhoWins(17));
    Assert.assertEquals(2, wg.getWhoWins(40));
  }
}
