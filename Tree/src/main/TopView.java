package main;

import java.util.HashMap;
import java.util.Map;

import main.BinarySearchTree.BSTNode;

/**
 * Print top view of a binary tree
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 *
 */
public class TopView {
  public static void print(BSTNode root) {
    if (root == null)
      return;
    Map<Integer, Integer> m = new HashMap<Integer, Integer>();
    printRecursive(root, 0, m);
  }

  private static void printRecursive(BSTNode root, int distance, Map<Integer, Integer> m) {
    if (root == null)
      return;
    if (!m.containsKey(distance)) {
      System.out.print(root.data + " ");
      m.put(distance, root.data);
    }
    printRecursive(root.left, distance - 1, m);
    printRecursive(root.right, distance + 1, m);
  }
}
