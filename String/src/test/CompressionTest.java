package test;

import main.Compression;

import org.junit.Assert;
import org.junit.Test;

public class CompressionTest {
  @Test
  public void test() {
    String str = "aabbbccc";
    Compression c = new Compression();
    Assert.assertEquals("a2b3c3", c.getCompressed(str));
    str = "abc";
    Assert.assertEquals("abc", c.getCompressed(str));
  }
}
