package main;

import main.BinarySearchTree.BSTNode;

public class RemoveKeysOutsideRange {
  public BSTNode remove(BSTNode root, int min, int max) {
    if (root == null)
      return null;
    // Do a postorder traversal
    root.left = remove(root.left, min, max);
    root.right = remove(root.right, min, max);
    // If root's data is less than min, return root's right
    if (root.data < min) {
      return root.right;
    }
    // If root's data is greater than max, return root's left
    if (root.data > max) {
      return root.left;
    }
    // Return root
    return root;
  }
}
