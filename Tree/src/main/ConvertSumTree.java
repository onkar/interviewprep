package main;

import main.BinarySearchTree.BSTNode;

/**
 * Convert given tree to the sum tree. root's data = root's data + root.left's data + root.right's
 * data. The value remains same for the leaf nodes.
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class ConvertSumTree {
  private final BSTNode root;

  public ConvertSumTree(BSTNode root) {
    this.root = root;
  }

  public BSTNode convertToSumTree() {
    root.data = convertToSumTreeUtil(root);
    return root;
  }

  private int convertToSumTreeUtil(BSTNode root) {
    if (root == null) {
      return 0;
    }
    root.data += convertToSumTreeUtil(root.left) + convertToSumTreeUtil(root.right);
    return root.data;
  }
}
