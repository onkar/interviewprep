package main;

import main.BinarySearchTree.BSTNode;

/**
 * Print all paths from root to leaf
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 *
 */
public class AllPaths {
  public static void print(BSTNode root) {
    // Calculate height, allocate path array and call recursive method
    int height = getHeight(root);
    int[] path = new int[height];
    printPathRecursive(root, path, 0);
  }

  private static void printPathRecursive(BSTNode root, int[] path, int level) {
    if (root == null)
      return;

    // Add current data in the array and increment the level
    path[level] = root.data;
    ++level;

    if (root.left == null && root.right == null) {
      // If you have reached leaf node, print the path
      printPath(path, level);
    }

    // Recurse in left and right subtrees. The level has already been incremented before.
    printPathRecursive(root.left, path, level);
    printPathRecursive(root.right, path, level);
  }

  private static void printPath(int[] path, int level) {
    for (int i = 0; i < level; i++)
      System.out.print(path[i] + " ");
    System.out.println();
  }

  private static int getHeight(BSTNode root) {
    if (root == null)
      return 0;
    return 1 + Math.max(getHeight(root.left), getHeight(root.right));
  }
}
