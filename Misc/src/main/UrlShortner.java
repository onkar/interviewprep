package main;

/**
 * Design and implement a URL shortener class.
 * 
 * The idea is to have 3 columns in the database - Auto incrementing integer called id, String URL
 * for the URL user entered, String ShortURL for the shortened version of the URL. For each string,
 * we use the auto incrementing id as a unique number from which a string should be generated, which
 * in turn becomes a part of the shortened URL.
 * 
 * Source : http://stackoverflow.com/questions/742013/how-to-code-a-url-shortener
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class UrlShortner {
  private static final String ALPHABETS =
      "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
  private static final int base = ALPHABETS.length();

  public static String encode(int num) {
    StringBuilder sb = new StringBuilder();
    while (num > 0) {
      sb.append(ALPHABETS.charAt(num % base));
      num = num / base;
    }
    return sb.reverse().toString();
  }

  public static int decode(String str) {
    int num = 0;
    for (int i = 0; i < str.length(); i++) {
      num = num * base + ALPHABETS.indexOf(str.charAt(i));
    }
    return num;
  }

}
