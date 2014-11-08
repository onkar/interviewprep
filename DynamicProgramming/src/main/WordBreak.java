package main;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an input string and a dictionary of words, find out if the input string can be segmented
 * into a space-separated sequence of dictionary words
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 *
 */
public class WordBreak {
  Set<String> dictionary;

  public WordBreak() {
    dictionary = new HashSet<String>();
  }

  public void insertInDictionary(String s) {
    dictionary.add(s);
  }

  boolean dictionaryContains(String s) {
    return dictionary.contains(s);
  }

  public boolean wordBreaks(String str) {
    if (str == null) {
      return false;
    }
    boolean[] checker = new boolean[str.length() + 1];
    checker[0] = true;
    for (int i = 1; i <= str.length(); i++) {
      for (int k = 0; k < i; k++) {
        String sub = str.substring(k, i);
        if (checker[k] == true && dictionaryContains(sub)) {
          checker[i] = true;
        }
        if (checker[i] == true) {
          break;
        }
      }
    }
    return checker[str.length()];
  }
}
