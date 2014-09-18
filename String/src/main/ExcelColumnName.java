package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <pre>
 * Given a column number, find its corresponding Excel column name. 
 * Following are more examples -
 *    Input          Output
 *    26             Z
 *    51             AY
 *    52             AZ
 *    80             CB
 *    676            YZ
 *    702            ZZ
 *    705            AAC
 * </pre>
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class ExcelColumnName {
  public String getExcelCol(int number) {
    int Alphabets = 26;
    List<Character> str = new ArrayList<Character>();
    while(number > 0) {
      // Calculate reminder
      int reminder = number % Alphabets;
      if (reminder == 0) {
        str.add('Z');
        // Subtract 1 because A is considered as 1st character and not 0th
        number = number / Alphabets - 1;
      } else {
        // Subtract 1 for the same reason mentioned above
        char x = (char) (reminder - 1 + 'A');
        str.add(x);
        number = number / Alphabets;
      }
    }
    // Use collections to sort the list
    Collections.reverse(str);
    // Use StringBuilder when creating a string from arraylist
    StringBuilder sb = new StringBuilder();
    for (char s : str) {
      sb.append(s);
    }
    return sb.toString();
  }
}
