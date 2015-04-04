package main;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Given an input string and a dictionary of words, segment the input string into a space-separated
 * sequence of dictionary words if possible. For example, if the input string is "applepie" and
 * dictionary contains a standard set of English words, then we would return the string "apple pie"
 * as output. If you have {"come", "back", "together", "to", "get", "her"} in dictionary, it should
 * return "come back together" instead of "come back to get her".
 * 
 * Source - http://thenoisychannel.com/2011/08/08/retiring-a-great-interview-problem
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 *
 */
public class WordBreak {
  public static String segmentStringSimple(String input, Set<String> dictionary) {
    int length = input.length();
    for (int i = 1; i < length; i++) {
      String prefix = input.substring(0, i);
      if (dictionary.contains(prefix)) {
        String suffix = input.substring(i, length);
        if (dictionary.contains(suffix)) {
          return prefix + " " + suffix;
        }
      }
    }
    return null;
  }

  // O(2 ^ n) solution
  public static String segmentStringRecursiveBacktracking(String input, Set<String> dictionary) {
    if (dictionary.contains(input)) {
      return input;
    }
    int length = input.length();
    for (int i = 1; i < length; i++) {
      String prefix = input.substring(0, i);
      if (dictionary.contains(prefix)) {
        String suffix = input.substring(i, length);
        String segmentSuffix = segmentStringRecursiveBacktracking(suffix, dictionary);
        if (segmentSuffix != null) {
          return prefix + " " + segmentSuffix;
        }
      }
    }
    return null;
  }

  // O (n ^ 2) solution
  public static String segmentStringMemoized(String input, Set<String> dictionary) {
    if (dictionary.contains(input)) {
      return input;
    }
    if (lookupMap.containsKey(input)) {
      return lookupMap.get(input);
    }

    int length = input.length();
    for (int i = 1; i < length; i++) {
      String prefix = input.substring(0, i);
      if (dictionary.contains(prefix)) {
        String suffix = input.substring(i, length);
        String segmentSuffix = segmentStringMemoized(suffix, dictionary);
        if (segmentSuffix != null) {
          lookupMap.put(input, prefix + " " + segmentSuffix);
          return prefix + " " + segmentSuffix;
        }
      }
    }
    lookupMap.put(input, null);
    return null;
  }

  private static Map<String, String> lookupMap = new HashMap<String, String>();
}
