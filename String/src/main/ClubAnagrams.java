package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given the array of strings, club the anagrams together.
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 *
 */
public class ClubAnagrams {
  public List<String> clubAnagrams(String[] list) {
    if (list.length < 2) {
      return new ArrayList<String>();
    }
    // Map to keep the list of anagrams
    Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
    for (String s : list) {
      // Sort the string and keep it as the key
      String key = sortChars(s);
      if (!map.containsKey(key)) {
        // If the key doesn't exist, add it in the map and keep empty list as the value
        ArrayList<String> value = new ArrayList<String>();
        map.put(key, value);
      }
      // Otherwise add current string as the value for the key
      map.get(key).add(s);
    }
    // Go through the map and if the anagram size is greater than 1, add it in the result
    ArrayList<String> result = new ArrayList<String>();
    for (String key : map.keySet()) {
      ArrayList<String> anagrams = map.get(key);
      if (anagrams.size() > 1) {
        result.addAll(anagrams);
      }
    }
    return result;
  }

  // Sort the characters in the string and return as a string
  private String sortChars(String s) {
    char[] contents = s.toCharArray();
    Arrays.sort(contents);
    return new String(contents);
  }
}
