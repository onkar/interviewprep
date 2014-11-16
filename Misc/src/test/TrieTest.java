package test;

import main.Trie;

import org.junit.Assert;
import org.junit.Test;

public class TrieTest {
  @Test
  public void test() {
    Trie t = new Trie();
    t.insert("an");
    t.insert("and");
    Assert.assertTrue(t.search("and"));
    Assert.assertTrue(t.search("an"));
    Assert.assertFalse(t.search("andes"));
  }
}
