package main;

/**
 * <pre>
 * Input: str1 = "AB", str2 = "CD"
 * Output: ABCD, ACBD, ACDB, CABD, CADB, CDAB An interleaved string
 * of given two strings preserves the order of characters in individual strings. For example, in all
 * the interleavings of above first example, ÔAÕ comes before ÔBÕ and ÔCÕ comes before ÔDÕ. -
 * https://www.youtube.com/watch?v=jspbN5bNPqM
 * </pre>
 * 
 * @author onkar.deshpande@gmail.com
 *
 */
public class Interleaving {

  public void printInterleaving(String s1, String s2) {
    interleavingRec(s1, s2, "");
  }

  private void interleavingRec(String s1, String s2, String result) {
    if (s1.length() == 0 && s2.length() == 0) {
      System.out.println(result);
      return;
    }
    if (s1.length() != 0) {
      interleavingRec(s1.substring(1), s2, result + s1.charAt(0));
    }
    if (s2.length() != 0) {
      interleavingRec(s1, s2.substring(1), result + s2.charAt(0));
    }
  }
}
