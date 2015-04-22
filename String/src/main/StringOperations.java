package main;

public class StringOperations {

  /**
   * Return the index of the first occurrence of pattern in source
   * 
   * @param source
   * @param pattern
   * @return
   */
  public static int indexOf(String source, String pattern) {
    // Get both source and pattern lengths
    int sourceLength = source.length();
    int patternLength = pattern.length();

    if (pattern.length() == 0 || pattern == null) {
      return -1;
    }

    // Go through the source string
    for (int i = 0; i < sourceLength; i++) {
      // Save current index i to a temporary variable k, which is used for matching further
      // characters. k is the index for the source string while j is the index for the pattern
      // string. Initialize j to 0 because we want to search pattern from the first character
      // onwards.
      int k = i;
      int j = 0;
      // While characters match and indices are within the boundaries, keep moving
      while (j < patternLength && k < sourceLength && pattern.charAt(j) == source.charAt(k)) {
        j++;
        k++;
        // When j equals pattern length, we know we have found the match. And since this match was
        // for position i in the source string, return i as the index of the match.
        if (j == patternLength) {
          return i;
        }
      }
    }
    return -1;
  }

  /**
   * Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part
   * of haystack.
   * 
   * @param haystack
   * @param needle
   * @return
   */
  public static String strStr(String haystack, String needle) {
    int haystackLength = haystack.length();
    int needleLength = needle.length();

    if (needleLength == 0 || needle == null)
      return null;

    for (int i = 0; i < haystackLength; i++) {
      int k = i;
      int j = 0;
      while (j < needleLength && k < haystackLength && needle.charAt(j) == haystack.charAt(k)) {
        j++;
        k++;
        if (j == needleLength) {
          return haystack.substring(i);
        }
      }
    }
    return null;
  }
}
