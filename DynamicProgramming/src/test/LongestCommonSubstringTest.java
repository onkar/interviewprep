package test;

import main.LongestCommonSubstring;

import org.junit.Assert;
import org.junit.Test;

public class LongestCommonSubstringTest {
  @Test
  public void test() {
    LongestCommonSubstring lcs = new LongestCommonSubstring();
    Assert.assertEquals(5, lcs.getLength("GeeksforGeeks", "GeeksQuiz"));
    Assert.assertEquals("Geeks", lcs.getLongestCommonSubstring("GeeksforGeeks", "GeeksQuiz"));
  }
}
