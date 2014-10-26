package main;

import main.BinarySearchTree.BSTNode;

/**
 * To check if a tree is height-balanced, get the height of left and right subtrees. Return true if
 * difference between heights is not more than 1 and left and right subtrees are balanced, otherwise
 * return false.
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class BalancedBinaryTree {
  public boolean isBalanced(BSTNode root) {
    if (root == null) {
      return true;
    }
    int leftHeight = getHeight(root.left);
    int rightHeight = getHeight(root.right);
    if (Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right)) {
      return true;
    } else {
      return false;
    }
  }

  private int getHeight(BSTNode root) {
    if (root == null) {
      return 0;
    }
    int leftHeight = getHeight(root.left);
    int rightHeight = getHeight(root.right);
    if (leftHeight > rightHeight) {
      return leftHeight + 1;
    } else {
      return rightHeight + 1;
    }
  }
}
