package test;

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
}
