package main;

/**
 * Print power set of an array
 * 
 * <pre>
 * Set  = [a,b,c]
 * power_set_size = pow(2, 3) = 8
 * Run for binary counter = 000 to 111
 * Value of Counter            Subset
 *     000                    -> Empty set
 *     001                    -> a
 *     011                    -> ab
 *     100                     -> c
 *     101                     -> ac
 *     110                     -> bc
 *     111                     -> abc
 * </pre>
 *
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 *
 */
public class PowerSet {
  public void printPowerSet(int[] array) {
    int n = array.length;
    int powerSetSize = 1 << n;
    // Go from 000, 001, ..., 111
    for (int i = 0; i < powerSetSize; i++) {
      // Inner loop for index of array elements
      for (int j = 0; j < n; j++) {
        // Set one bit to 1 at a time for given j using 1 << j. And for each position, AND it with
        // i. If the result of ANDing is non-zero, print array[j]
        if ((i & (1 << j)) != 0) {
          System.out.print(array[j] + " ");
        }
      }
      System.out.println();
    }
  }
}
