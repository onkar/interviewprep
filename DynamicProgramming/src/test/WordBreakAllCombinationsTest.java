package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import main.WordBreakAllCombinations;

import org.junit.Assert;
import org.junit.Test;

public class WordBreakAllCombinationsTest {
  @Test
  public void test() {
    Set<String> dict = new HashSet<String>();
    String[] array = {"cat", "cats", "and", "sand", "dog"};
    dict.addAll(Arrays.asList(array));
    List<ArrayList<String>> output = WordBreakAllCombinations.getCombinations("catsanddog", dict);
    Assert.assertEquals(2, output.size());

    List<String> first = output.get(0);
    Assert.assertEquals("cat", first.get(0));
    Assert.assertEquals("sand", first.get(1));
    Assert.assertEquals("dog", first.get(2));

    List<String> second = output.get(1);
    Assert.assertEquals("cats", second.get(0));
    Assert.assertEquals("and", second.get(1));
    Assert.assertEquals("dog", second.get(2));
  }
}
