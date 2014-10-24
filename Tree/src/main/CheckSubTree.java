package main;

import main.BinarySearchTree.BSTNode;

/**
 * Check if the given tree(other) is a subtree of a tree(root).
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class CheckSubTree {

  public boolean isSubTree(BSTNode root, BSTNode other) {
    // Any null tree is a subtree
    if (other == null) {
      return true;
    }
    // If source tree doesn't exist, return false
    if (root == null) {
      return false;
    }
    // If both trees are identical, then they are subtrees of each other.
    if (isIdentical(root, other)) {
      return true;
    }
    // Check if the subtree lies in root's left or root's right
    return isSubTree(root.left, other) || isSubTree(root.right, other);
  }

  private boolean isIdentical(BSTNode root, BSTNode other) {
    if (root == null && other == null) {
      // If both of them are null, then they're identical
      return true;
    }
    if (root == null || other == null) {
      // If only one of them is null (because it hasn't passed the if check above, they aren't
      // identical
      return false;
    }
    // Check if data of both nodes match and if it does, recurse in left and right subtrees for both
    // trees
    return root.data == other.data && isIdentical(root.left, other.left)
        && isIdentical(root.right, other.right);
  }
}
