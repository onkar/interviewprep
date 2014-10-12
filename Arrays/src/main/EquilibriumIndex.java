package main;

/**
 * Equilibrium index is an index i s.t the sum of elements at the lower indices less than i is equal
 * to the sum of the elements at indices greater than i. Find such index in the array.
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class EquilibriumIndex {
  private final int[] array;

  public EquilibriumIndex(int[] array) {
    this.array = array;
  }

  public int getEquilibriumIndex() {
    int sum = 0, leftSum = 0;
    for (int i = 0; i < array.length; i++) {
      sum += array[i];
    }
    for (int i = 0; i < array.length; i++) {
      sum -= array[i];
      if (sum == leftSum) {
        return i;
      }
      leftSum += array[i];
    }
    return -1;
  }
}
