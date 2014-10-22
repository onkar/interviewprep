package main;

import java.util.HashMap;
import java.util.LinkedHashMap;

import main.BinarySearchTree.BSTNode;

public class VerticleSum {
  private final HashMap<Integer, Integer> hashmap = new LinkedHashMap<Integer, Integer>();

  public HashMap<Integer, Integer> getVerticleSum(BSTNode root) {
    if (root == null) {
      return null;
    }
    // Start the recursion with level as 0
    verticleSumUtil(root, 0);
    return hashmap;
  }

  private void verticleSumUtil(BSTNode root, int level) {
    if (root == null) {
      return;
    }
    // Recurse into the left subtree and each time we recurse, subtract one from the level
    verticleSumUtil(root.left, level - 1);
    int previousSum;
    if (!hashmap.containsKey(level)) {
      // If hashmap doesn't have value corresponding to this level, set previous sum to 0
      previousSum = 0;
    } else {
      // Else read the value from hashmap
      previousSum = hashmap.get(level);
    }
    // Add current node's data in previousSum and put it as a value for given level
    hashmap.put(level, previousSum + root.data);
    // Recurse into the right subtree and increment the level by one
    verticleSumUtil(root.right, level + 1);
  }
}
