package main;

/**
 * Given an array, return a product array such that product[i] is a product of all elements of the
 * array except the one at index i.
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class ProductOfAllElements {
  private final int[] array;

  public ProductOfAllElements(int[] array) {
    this.array = array;
  }

  public int[] getProduct() {
    int temp = 1;
    int[] product = new int[array.length];

    // product[i] contains product of all elements from 0 to i-1
    for (int i = 0; i < array.length; i++) {
      product[i] = temp;
      temp *= array[i];
    }

    temp = 1;
    // re-initialize temp to 1 and update product array from right to left.
    for (int i = array.length - 1; i >= 0; i--) {
      product[i] *= temp;
      temp *= array[i];
    }
    return product;
  }
}
