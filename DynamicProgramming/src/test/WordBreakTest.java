package test;

import main.WordBreak;

import org.junit.Assert;
import org.junit.Test;

public class WordBreakTest {
  @Test
  public void test() {
    WordBreak wb = new WordBreak();
    wb.insertInDictionary("leet");
    wb.insertInDictionary("code");
    Assert.assertTrue(wb.wordBreaks("leetcode"));
  }
}
