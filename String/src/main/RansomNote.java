package main;

import java.util.HashMap;
import java.util.Map;

/**
 * Kidnaper kidnaps you and write a ransom note. He doesn't write it with hand but uses magazine to
 * create the note. We need to find given a ransom string and magazine string, is it possible to
 * create given ransom note. Kidnaper can use individual characters of words.
 * 
 * This problem can be extended with a limitation that kidnaper can only use words (not characters).
 * In that case, we build a trie of magazine words. The leaf node saves the number of times this
 * word has occurred. Then we scan ransom string and for each word, we decrement the counter in
 * trie. If we see that the count is zero already, we return false.
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class RansomNote {
  private final String magazineString;
  private final String ransomString;

  public RansomNote(String magazineString, String ransomString) {
    this.magazineString = magazineString;
    this.ransomString = ransomString;
  }

  public boolean isRansomFromMagazine() {
    Map<Character, Integer> charOccurence = new HashMap<Character, Integer>();

    // Populate the hashmap with magazine character occurrences
    for (int i = 0; i < magazineString.length(); i++) {
      if (charOccurence.containsKey(magazineString.charAt(i))) {
        int val = charOccurence.get(magazineString.charAt(i));
        charOccurence.put(magazineString.charAt(i), ++val);
      } else {
        charOccurence.put(magazineString.charAt(i), 1);
      }
    }

    // Go through the ransom string, see if each character is present in the hashmap. If not, return
    // false. If character is present, check the occurrence count, if it is non-zero then decrement
    // it. When we try to decrement already zero count, we return false
    for (int i = 0; i < ransomString.length(); i++) {
      if (!charOccurence.containsKey(ransomString.charAt(i))) {
        // All characters in ransom string must be present in the magazine
        return false;
      } else {
        if (charOccurence.get(ransomString.charAt(i)) == 0) {
          return false;
        } else {
          int val = charOccurence.get(ransomString.charAt(i));
          --val;
          charOccurence.put(ransomString.charAt(i), val);
        }
      }
    }
    return true;
  }
}
