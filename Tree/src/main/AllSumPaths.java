package main;

import main.BinarySearchTree.BSTNode;

/**
 * You are given a binary tree in which each node contains a value. Design an algorithm to print all
 * paths which sum to a given value. The path does not need to start or end at the root or a leaf.
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 *
 */
public class AllSumPaths {

  public void printAllSumPath(BSTNode root, int sum) {
    // Get the height and allocate the path array
    int height = getHeight(root);
    int[] path = new int[height];
    findSumRec(root, sum, path, 0);
  }

  private int getHeight(BSTNode root) {
    if (root == null)
      return 0;
    else
      return 1 + Math.max(getHeight(root.left), getHeight(root.right));
  }

  private void findSumRec(BSTNode node, int sum, int[] path, int level) {
    if (node == null)
      return;
    // Add the node's data in path array at index level
    path[level] = node.data;
    int t = 0;
    for (int i = level; i >= 0; i--) {
      // Add all elements in the path array and after each addition check if the addition is same as
      // the sum. When it equals, we should print the path array.
      t += path[i];
      if (t == sum) {
        print(path, i, level);
      }
    }
    // Recurse into left and right subtrees with incremented level
    findSumRec(node.left, sum, path, level + 1);
    findSumRec(node.right, sum, path, level + 1);

    path[level] = Integer.MIN_VALUE;
  }

  // Print path array from start to (and including) end
  private void print(int[] path, int start, int end) {
    for (int i = start; i <= end; i++)
      System.out.println(path[i] + " ");

    System.out.println();
  }
}
