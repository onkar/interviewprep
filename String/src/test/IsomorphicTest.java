package test;

import main.Isomorphic;

import org.junit.Assert;
import org.junit.Test;

public class IsomorphicTest {
  @Test
  public void test() {
    Assert.assertTrue(Isomorphic.areIsomorphic("foo", "app"));
    Assert.assertFalse(Isomorphic.areIsomorphic("foo", "bar"));
    Assert.assertTrue(Isomorphic.areIsomorphic("turtle", "turtle"));
    Assert.assertTrue(Isomorphic.areIsomorphic("ab", "ca"));
  }
}
