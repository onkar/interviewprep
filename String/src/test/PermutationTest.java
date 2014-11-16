package test;

import main.Permutations;

import org.junit.Test;

public class PermutationTest {
  @Test
  public void test() {
    Permutations p = new Permutations();
    p.printPermutationsInOrder("abc");
    System.out.println();
    p.printPermutationsNotInOrder("abc");
  }
}
