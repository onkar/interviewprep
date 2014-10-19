package main;

import main.BinarySearchTree.BSTNode;

public class BinaryTreeIsBST {
  public boolean isBST(BSTNode root) {
    return isBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private boolean isBSTHelper(BSTNode root, int minValue, int maxValue) {
    // An empty binary tree is always a BST
    if (root == null) {
      return true;
    }

    if (minValue < root.data && maxValue > root.data) {
      // Minimum value should be less that root and maximum value should be greater than root. If
      // true, recursively call in left and right subtree.
      return isBSTHelper(root.left, minValue, root.data)
          && isBSTHelper(root.right, root.data, maxValue);
    } else {
      // The given tree is not a BST
      return false;
    }
  }
}
