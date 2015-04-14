package test;

import main.WordCount;

import org.junit.Assert;
import org.junit.Test;

public class WordCountTest {
  @Test
  public void test() {
    String str = "My name is    Anthony Gonsalves. Anthony Gonsalvessss !!!";
    // Not that !!! is not considered a valid word here.
    Assert.assertEquals(7, WordCount.count(str));
  }
}
