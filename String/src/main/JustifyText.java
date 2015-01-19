package main;

import java.util.StringTokenizer;

public class JustifyText {
  public static String justify(String input, int justifyLength) {
    if (input.length() == justifyLength)
      return input;
    if (input.length() > justifyLength) {
      System.out.println("Input string is longer than justify length");
      return input;
    }
    StringTokenizer st = new StringTokenizer(input, " ");
    int count = st.countTokens() - 1;
    int totalSpacing = justifyLength - input.length() + count;

    // Spaces to be put after individual word
    int individualSpacing = totalSpacing / count;
    // Extra padding spaces
    int padding = totalSpacing % count;

    StringBuilder sb = new StringBuilder();
    while (st.hasMoreTokens()) {
      sb.append(st.nextToken());
      if (st.hasMoreTokens()) {
        for (int i = 0; i < individualSpacing; i++) {
          sb.append(" ");
        }
      }
      if (padding > 0) {
        sb.append(" ");
        --padding;
      }
    }
    return sb.toString();
  }
}
