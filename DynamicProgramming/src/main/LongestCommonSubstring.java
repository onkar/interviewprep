package main;

/**
 * Given two strings ‘X’ and ‘Y’, find the length of the longest common substring. For example, if
 * the given strings are “GeeksforGeeks” and “GeeksQuiz”, the output should be 5 as longest common
 * substring is “Geeks”
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 *
 */
public class LongestCommonSubstring {
  private int[][] LCSuffix;
  private int substringLength;

  public int getLength(String s1, String s2) {
    LCSuffix = new int[s1.length() + 1][s2.length() + 1];
    substringLength = 0;

    for (int i = 0; i <= s1.length(); i++) {
      for (int j = 0; j <= s2.length(); j++) {
        if (i == 0 || j == 0)
          LCSuffix[i][j] = 0;
        else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
          LCSuffix[i][j] = LCSuffix[i - 1][j - 1] + 1;
          substringLength = Math.max(substringLength, LCSuffix[i][j]);
        } else {
          LCSuffix[i][j] = 0;
        }
      }
    }
    return substringLength;
  }
}
