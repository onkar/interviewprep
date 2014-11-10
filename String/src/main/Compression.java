package main;

/**
 * Implement a method to perform basic string compression using the counts of repeated characters.
 * For example, the string aabcccccaaa would become a2blc5a3. If the "compressed" string would not
 * become smaller than the original string, your method should return the original string.
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 *
 */
public class Compression {

  public String getCompressed(String incoming) {
    if (countCompression(incoming) > incoming.length()) {
      return incoming;
    }
    StringBuffer sb = new StringBuffer();
    char last = incoming.charAt(0);
    int count = 1;
    for (int i = 1; i < incoming.length(); i++) {
      if (incoming.charAt(i) == last) {
        count++;
      } else {
        sb.append(last);
        sb.append(count);
        last = incoming.charAt(i);
        count = 1;
      }
    }
    sb.append(last);
    sb.append(count);
    return sb.toString();
  }

  private int countCompression(String incoming) {
    int count = 1;
    char last = incoming.charAt(0);
    int compressionSize = 0;
    for (int i = 1; i < incoming.length(); i++) {
      if (incoming.charAt(i) == last) {
        count++;
      } else {
        last = incoming.charAt(i);
        compressionSize += 1 + String.valueOf(count).length();
        count = 1;
      }
    }
    compressionSize += 1 + String.valueOf(count).length();
    return compressionSize;
  }
}
