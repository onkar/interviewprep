package test;

import main.RepeatingChars;

import org.junit.Assert;
import org.junit.Test;

public class RepeatingCharsTest {
  @Test
  public void testOldestRepeatingChar() {
    String str1 = "bacdeba";
    Assert.assertEquals(new Character('b'), RepeatingChars.oldestRepeatingChar(str1));
    String str2 = "abcd";
    Assert.assertNull(RepeatingChars.oldestRepeatingChar(str2));
  }

  @Test
  public void testNewestNonRepeatingChar() {
    String str1 = "bacdeba";
    Assert.assertEquals(new Character('e'), RepeatingChars.newestNonRepeatingChar(str1));
    String str2 = "aabbccdd";
    Assert.assertNull(RepeatingChars.newestNonRepeatingChar(str2));
  }
}
