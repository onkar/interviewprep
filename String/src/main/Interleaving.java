package main;

/**
 * <pre>
 * Input: str1 = "AB", str2 = "CD"
 * Output: ABCD, ACBD, ACDB, CABD, CADB, CDAB An interleaved string
 * of given two strings preserves the order of characters in individual strings. For example, in all
 * the interleaving of above first example, A comes before B and C comes before D. -
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

  public boolean areInterleaved(String s1, int s1Index, String s2, int s2Index, String s3,
      int s3Index) {
    if (s3Index == s3.length() - 1)
      return true;
    if (s1.charAt(s1Index) != s3.charAt(s3Index) && s2.charAt(s2Index) != s3.charAt(s3Index))
      return false;
    if (s1.charAt(s1Index) == s3.charAt(s3Index)) {
      if (areInterleaved(s1, ++s1Index, s2, s2Index, s3, ++s3Index))
        return true;
    }
    if (s2.charAt(s2Index) == s3.charAt(s3Index)) {
      if (areInterleaved(s1, s1Index, s2, ++s2Index, s3, ++s3Index))
        return true;
    }
    return false;
  }
}
