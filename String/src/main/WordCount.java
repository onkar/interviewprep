package main;

public class WordCount {
  public static int count(String str) {
    int wordCount = 0;
    boolean isWord = false;
    int end = str.length() - 1;

    for (int i = 0; i < str.length(); i++) {
      if (Character.isLetter(str.charAt(i)) && i != end) {
        // Check if the current character is a valid letter and we haven't reached the last
        // character of string. If this is the case, we have found a valid word.
        isWord = true;
      } else if (!Character.isLetter(str.charAt(i)) && isWord == true) {
        // Current character is not a letter but last word was valid. So, increment word counter and
        // set isWord to false
        ++wordCount;
        isWord = false;
      } else if (Character.isLetter(str.charAt(i)) && i == end) {
        // Current character is a valid letter and we have reached the end of the string. Increment
        // word counter.
        ++wordCount;
      }
    }
    return wordCount;
  }
}
