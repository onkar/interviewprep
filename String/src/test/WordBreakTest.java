package test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import main.WordBreak;

import org.junit.Test;

public class WordBreakTest {
  @Test
  public void test() {
    Set<String> dict = new HashSet<String>();
    String[] array1 = {"apple", "pie"};
    dict.addAll(Arrays.asList(array1));
    System.out.println(WordBreak.segmentStringSimple("applepie", dict));
    dict.clear();

    String[] array2 = {"come", "back", "together", "to", "get", "her"};
    dict.addAll(Arrays.asList(array2));
    System.out.println(WordBreak.segmentStringRecursiveBacktracking("comebacktogether", dict));
    System.out.println(WordBreak.segmentStringMemoized("comebacktogether", dict));
  }
}
