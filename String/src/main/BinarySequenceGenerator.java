package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an input, generate binary sequence. For example, given 2 as input, generate {00, 01, 10,
 * 11}
 * 
 * @author onkar.deshpande@gmail.com(Onkar Deshpande)
 *
 */
public class BinarySequenceGenerator {

  /**
   * Base case (length 1), Only two values: 0 and 1. For length > 1, prepend 0 and 1 to the
   * sequences from previous recursion. For example, for length of 2, prepending 0 and 1 to the
   * previous recursion output(0, 1): 00, 01, 10, 11.
   * 
   * @param length
   * @return
   */
  public static List<String> generate(int length) {
    List<String> result;
    if (length <= 1) {
      result = Arrays.asList("0", "1");
    } else {
      List<String> prevResult = generate(length - 1);
      List<String> temp = new ArrayList<String>();
      for (String s : prevResult) {
        temp.add("0" + s);
      }
      for (String s : prevResult) {
        temp.add("1" + s);
      }
      result = temp;
    }
    return result;
  }
}
