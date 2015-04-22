package test;

import junit.framework.Assert;
import main.StringOperations;

import org.junit.Test;

public class StringOperationsTest {
  @Test
  public void test() {
    Assert.assertEquals(4, StringOperations.indexOf("abcdbdca", "bd"));
    Assert.assertEquals("bdca", StringOperations.strStr("abcdbdca", "bd"));
  }
}
