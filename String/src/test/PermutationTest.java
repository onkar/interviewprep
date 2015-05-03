package test;

import main.Permutations;

import org.junit.Test;

public class PermutationTest {
  @Test
  public void test() {
    Permutations.printPermutationsInOrder("abc");
    System.out.println();
    Permutations.printPermutationsNotInOrder("abc");
    System.out.println();
    Permutations p = new Permutations("abc");
    p.permute();
  }
}
