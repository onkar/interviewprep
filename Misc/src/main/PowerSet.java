package main;

/**
 * Print power set of an array
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 *
 */
public class PowerSet {
  public void printPowerSet(int[] array) {
    int n = array.length;
    for (int i = 0; i < (1 << n); i++) {
      for (int j = 0; j < n; j++) {
        if ((i & (1 << j)) != 0) {
          System.out.print(array[j] + " ");
        }
      }
      System.out.println();
    }
  }
}
