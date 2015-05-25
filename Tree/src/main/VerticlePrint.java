package main;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import main.BinarySearchTree.BSTNode;

/**
 * Print tree vertically
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 *
 */
public class VerticlePrint {
  public static void print(BSTNode root) {
    if (root == null)
      return;
    Map<Integer, ArrayList<Integer>> m = new LinkedHashMap<Integer, ArrayList<Integer>>();
    printVerticleRecursive(root, 0, m);
    for (Entry<Integer, ArrayList<Integer>> e : m.entrySet()) {
      System.out.print("[");
      for (int i : e.getValue()) {
        System.out.print(i + " ");
      }
      System.out.print("] ");
    }
  }

  private static void printVerticleRecursive(BSTNode root, int distance,
      Map<Integer, ArrayList<Integer>> m) {
    if (root == null)
      return;

    printVerticleRecursive(root.left, distance - 1, m);

    if (!m.containsKey(distance)) {
      ArrayList<Integer> list = new ArrayList<Integer>();
      list.add(root.data);
      m.put(distance, list);
    } else {
      m.get(distance).add(root.data);
    }

    printVerticleRecursive(root.right, distance + 1, m);

  }
}
