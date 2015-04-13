package main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Implement an algorithm to print all valid (i.e., properly opened and closed) combinations of
 * n-pairs of parentheses.
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 *
 */
public class Parantheses {
  public static Set<String> generate(int n) {
    Set<String> set = new HashSet<String>();
    if (n == 0) {
      set.add("");
    } else {
      Set<String> prev = generate(n - 1);
      for (String str : prev) {
        for (int i = 0; i < str.length(); i++) {
          if (str.charAt(i) == '(') {
            String s = insertInside(str, i);
            set.add(s);
          }
        }
        if (!set.contains("()" + str)) {
          set.add("()" + str);
        }
      }
    }
    return set;
  }

  private static String insertInside(String str, int leftIndex) {
    String leftPart = str.substring(0, leftIndex + 1);
    String rightPart = str.substring(leftIndex + 1, str.length());
    return leftPart + "()" + rightPart;
  }

  /**
   * 
   * @param list The output list
   * @param leftRemaining Counter for left brackets
   * @param rightRemaining Counter for right bracket
   * @param str Array which maintains brackets
   * @param index Index in the array
   */
  private static void generateBetter(ArrayList<String> list, int leftRemaining, int rightRemaining,
      char[] str, int index) {
    if (leftRemaining < 0 || rightRemaining < leftRemaining) {
      return;
    }

    if (leftRemaining == 0 && rightRemaining == 0) {
      String s = String.copyValueOf(str);
      list.add(s);
    } else {
      if (leftRemaining > 0) {
        str[index] = '(';
        generateBetter(list, leftRemaining - 1, rightRemaining, str, index + 1);
      }
      if (rightRemaining > 0) {
        str[index] = ')';
        generateBetter(list, leftRemaining, rightRemaining - 1, str, index + 1);
      }
    }
  }

  public static ArrayList<String> generateBetter(int count) {
    char[] str = new char[count * 2];
    ArrayList<String> list = new ArrayList<String>();
    generateBetter(list, count, count, str, 0);
    return list;
  }
}
