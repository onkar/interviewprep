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
  // This is an O(n^2) solution
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

  private int checkHeight(BSTNode root) {
    if (root == null) {
      return 0; // Empty tree has height 0
    }
    int leftHeight = checkHeight(root.left);
    if (leftHeight == -1) {
      return -1; // Not balanced, return -1
    }
    int rightHeight = checkHeight(root.right);
    if (rightHeight == -1) {
      return -1; // Not balanced, return -1
    }
    int heightDifference = leftHeight - rightHeight;
    if (Math.abs(heightDifference) > 1) {
      return -1; // Not balanced
    } else {
      // Return whichever (left or right) height is maximum
      return Math.max(leftHeight, rightHeight) + 1;
    }
  }

  // When checkHeight() is calculating the height, we can also calculate if the tree is balanced or
  // not. This way, we can make this run in O(n) time and O(height) space
  public boolean isBalancedBetter(BSTNode root) {
    if (checkHeight(root) == -1) {
      return false;
    }
    return true;
  }
}
