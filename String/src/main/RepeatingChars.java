package main;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Given a string, return oldest repeating character and newest non-repeating character.
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 *
 */
public class RepeatingChars {
  public static Character oldestRepeatingChar(String str) {
    // Note that LinkedHashMap preserves the insertion order
    Map<Character, Integer> m = new LinkedHashMap<Character, Integer>();
    process(str, m);
    Character result = null;
    for (Entry<Character, Integer> e : m.entrySet()) {
      if (e.getValue() > 1) {
        result = e.getKey();
        break;
      }
    }
    return result;
  }

  public static Character newestNonRepeatingChar(String str) {
    Map<Character, Integer> m = new LinkedHashMap<Character, Integer>();
    process(str, m);
    Character result = null;
    for (Entry<Character, Integer> e : m.entrySet()) {
      if (e.getValue() == 1)
        result = e.getKey();
    }
    return result;
  }

  private static void process(String str, Map<Character, Integer> m) {
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if (!m.containsKey(c)) {
        m.put(c, 1);
      } else {
        int count = m.get(c);
        m.put(c, ++count);
      }
    }
  }
}
