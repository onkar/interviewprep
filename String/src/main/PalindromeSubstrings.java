package main;

import java.util.HashSet;
import java.util.Set;

/**
 * Find all substrings that are palindromes. If the input is 'abba' then the possible palindromes
 * are a, b, bb, abba.
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 *
 */
public class PalindromeSubstrings {
  public Set<String> getSubstringThatArePalindrome(String str) {
    Set<String> result = new HashSet<String>();
    for (int i = 0; i < str.length(); i++) {
      // Expand even palindromes
      expandPalindroms(result, str, i, i + 1);
      // Expand odd palindromes
      expandPalindroms(result, str, i, i);
    }
    return result;
  }

  private void expandPalindroms(Set<String> result, String str, int i, int j) {
    while (i >= 0 && j < str.length() && str.charAt(i) == str.charAt(j)) {
      result.add(str.substring(i, j + 1));
      i--;
      j++;
    }
  }
}
