package test;

import main.MinInsertionsToPalindrome;

import org.junit.Assert;
import org.junit.Test;

public class MinInsertionsToPalindromeTest {
  @Test
  public void test() {
    MinInsertionsToPalindrome mp = new MinInsertionsToPalindrome();
    Assert.assertEquals(1, mp.minimumInsertionsToMakePalindrome("abb"));
    Assert.assertEquals(0, mp.minimumInsertionsToMakePalindrome("abba"));
    Assert.assertEquals(1, mp.minimumInsertionsToMakePalindrome("ab"));
    Assert.assertEquals(2, mp.minimumInsertionsToMakePalindrome("abc"));
  }
}
