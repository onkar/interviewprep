package test;

import java.util.Set;

import junit.framework.Assert;
import main.PalindromeSubstrings;

import org.junit.Test;

public class PalindromeSubstringsTest {
  @Test
  public void test() {
    PalindromeSubstrings ps = new PalindromeSubstrings();
    Set<String> result = ps.getSubstringThatArePalindrome("abba");
    for (String r : result) {
      System.out.println(r);
    }

    Assert.assertEquals("abcba", ps.longestPalindromicSubstring("abbaabcba"));
  }
}
