package main;

/**
 * <pre>
 * Print combinations of a string.
 * Source : http://javahungry.blogspot.com/2014/02/algorithm-for-combinations-of-string-java-code-with-example.html
 * </pre>
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 *
 */
public class Combinations {
  private final String str;
  private final StringBuilder sb;

  public Combinations(String str) {
    this.str = str;
    this.sb = new StringBuilder();
  }

  public void combine() {
    combine(0);
  }

  private void combine(int start) {
    for (int i = start; i < str.length(); i++) {
      sb.append(str.charAt(i));
      System.out.println(sb);
      if (i < str.length()) {
        combine(i + 1);
      }
      sb.setLength(sb.length() - 1);
    }
  }
}
