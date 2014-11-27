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
      expandPalindromes(result, str, i, i + 1);
      // Expand odd palindromes
      expandPalindromes(result, str, i, i);
    }
    return result;
  }

  private void expandPalindromes(Set<String> result, String str, int i, int j) {
    while (i >= 0 && j < str.length() && str.charAt(i) == str.charAt(j)) {
      result.add(str.substring(i, j + 1));
      i--;
      j++;
    }
  }

  public String longestPalindromicSubstring(String str) {
    if (str.length() == 0)
      return "";
    String longestPalindrome = str.substring(0, 1);
    for (int i = 0; i < str.length() - 1; i++) {
      String temp = expandPalindromes(str, i, i + 1);
      if (temp.length() > longestPalindrome.length())
        longestPalindrome = temp;
      temp = expandPalindromes(str, i, i);
      if (temp.length() > longestPalindrome.length())
        longestPalindrome = temp;
    }
    return longestPalindrome;
  }

  private String expandPalindromes(String str, int begin, int end) {
    // Note the end <= str.length() - 1 condition
    while (begin >= 0 && end <= str.length() - 1 && str.charAt(begin) == str.charAt(end)) {
      begin--;
      end++;
    }
    // Note the begin + 1 because after while loop begin = -1 and end = str.length() - 1
    return str.substring(begin + 1, end);
  }
}
