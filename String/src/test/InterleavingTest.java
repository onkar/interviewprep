package test;

import junit.framework.Assert;
import main.Interleaving;

import org.junit.Test;

public class InterleavingTest {
  @Test
  public void test() {
    String s1 = "ab";
    String s2 = "cd";
    Interleaving il = new Interleaving();
    il.printInterleaving(s1, s2);
  }

  @Test
  public void testIfInterleaved() {
    String s1 = new String("ab");
    String s2 = new String("cd");
    String s3 = new String("acbd");
    Interleaving il = new Interleaving();
    Assert.assertTrue(il.areInterleaved(s1, 0, s2, 0, s3, 0));
  }
}
