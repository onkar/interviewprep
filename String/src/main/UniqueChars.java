package main;

import java.util.HashSet;
import java.util.Set;

public class UniqueChars {
  public boolean hasUniqueChars(String str) {
    Set<Character> charSet = new HashSet<Character>();
    for (char c : str.toCharArray()) {
      if (!charSet.contains(c)) {
        charSet.add(c);
      } else {
        return false;
      }
    }
    return true;
  }

  /**
   * Here we use just an integer and check if the bit at index value is set or not. If it's set, we
   * return false. For each scanned character, we set it to true.
   * 
   * @param str
   * @return
   */
  public boolean hasUniqueCharsNoExtraDS(String str) {
    int checker = 0;
    for (int i = 0; i < str.length(); i++) {
      int val = str.charAt(i) - 'a';
      if ((checker & (1 << val)) > 0) {
        return false;
      }
      checker |= (1 << val);
    }
    return true;
  }
}
