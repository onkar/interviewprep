package main;

public class Permutations {
  public void printPermutationsInOrder(String str) {
    permutationInOrder("", str);
  }

  // Try each letter as the first letter and find all permutations of remaining letters using
  // recursion. The base case is when input is an empty string, the only permutation is an empty
  // string.
  // Source - http://introcs.cs.princeton.edu/java/23recursion/Permutations.java.html
  private void permutationInOrder(String prefix, String str) {
    int n = str.length();
    if (n == 0)
      System.out.println(prefix);
    for (int i = 0; i < n; i++)
      permutationInOrder(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
  }

  public void printPermutationsNotInOrder(String str) {
    int length = str.length();
    char[] array = new char[length];
    for (int i = 0; i < length; i++) {
      array[i] = str.charAt(i);
    }
    permutationNotInOrder(array, length);
  }

  private void permutationNotInOrder(char[] array, int length) {
    if (length == 1) {
      System.out.println(array);
    }
    for (int i = 0; i < length; i++) {
      swap(array, i, length - 1);
      permutationNotInOrder(array, length - 1);
      swap(array, i, length - 1);
    }
  }

  private void swap(char[] array, int i, int j) {
    char temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
