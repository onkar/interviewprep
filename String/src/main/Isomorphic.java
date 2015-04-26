package main;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two (dictionary) words as Strings, determine if they are isomorphic. Two words are called
 * isomorphic if the letters in one word can be remapped to get the second word. Remapping a letter
 * means replacing all occurrences of it with another letter while the ordering of the letters
 * remains unchanged. No two letters may map to the same letter, but a letter may map to itself.
 * Example: Given "foo", "app"; returns true we can map 'f' -> 'a' and 'o' -> 'p' Given "bar",
 * "foo"; returns false we can't map both 'a' and 'r' to 'o' Given "turtle", "tletur"; returns true
 * we can map 't' -> 't', 'u' -> 'l', 'r' -> 'e', 'l' -> 'u', 'e' -'r' Given "ab", "ca"; returns
 * true we can map 'a' -> 'c', 'b'
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 *
 */
public class Isomorphic {
  public static boolean areIsomorphic(String s1, String s2) {
    if (s1.length() != s2.length())
      return false;
    Map<Character, Integer> m1 = new HashMap<Character, Integer>();
    Map<Character, Integer> m2 = new HashMap<Character, Integer>();
    StringBuilder sb1 = new StringBuilder();
    StringBuilder sb2 = new StringBuilder();

    updateMapAndEncoding(s1, m1, sb1);
    updateMapAndEncoding(s2, m2, sb2);

    return sb1.toString().equals(sb2.toString()) ? true : false;
  }

  private static void updateMapAndEncoding(String s, Map<Character, Integer> m, StringBuilder sb) {
    for (int i = 0; i < s.length(); i++) {
      if (!m.containsKey(s.charAt(i))) {
        m.put(s.charAt(i), i);
        sb.append(i);
      }
    }
  }
}
