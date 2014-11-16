package test;

import junit.framework.Assert;
import main.LongestCommonSubstring;

import org.junit.Test;

public class LongestCommonSubstringTest {
  @Test
  public void test() {
    LongestCommonSubstring lcs = new LongestCommonSubstring();
    Assert.assertEquals(5, lcs.getLength("GeeksforGeeks", "GeeksQuiz"));
  }
}
