package main;

/**
 * <pre>
 * Minimum insertions to make string palindrome
 * 
 *                             _____ minInsertions(str, l + 1, h - 1) if str[l] == str[h]
 *                            |
 * minInsertions(str, l, h) --|
 *                            |_____ min(minInsertions(str, l + 1, h), minInsertions(str, l, h - 1)) + 1
 *                                   if str[l] != str[h]
 * 
 * </pre>
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 *
 */
public class MinInsertionsToPalindrome {
  public int minimumInsertionsToMakePalindrome(String str) {
    return minInsertions(str, 0, str.length() - 1);
  }

  private int minInsertions(String str, int l, int h) {
    if (l > h)
      return Integer.MAX_VALUE;
    if (l == h)
      return 0;
    if (l == h - 1)
      return str.charAt(l) == str.charAt(h) ? 0 : 1;
    return str.charAt(l) == str.charAt(h) ? minInsertions(str, l + 1, h - 1) : Math.min(
        minInsertions(str, l, h - 1), minInsertions(str, l + 1, h)) + 1;
  }
}
