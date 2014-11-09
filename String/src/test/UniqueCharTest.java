package test;

import main.UniqueChars;

import org.junit.Assert;
import org.junit.Test;

public class UniqueCharTest {
  @Test
  public void test() {
    String str = "abcd";
    UniqueChars uc = new UniqueChars();
    Assert.assertTrue(uc.hasUniqueChars(str));
    Assert.assertTrue(uc.hasUniqueCharsNoExtraDS(str));
    str = "abbd";
    Assert.assertFalse(uc.hasUniqueChars(str));
    Assert.assertFalse(uc.hasUniqueCharsNoExtraDS(str));
  }
}
