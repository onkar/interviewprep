package main;

import main.BinarySearchTree.BSTNode;

/**
 * Find if the given binary tree has a path with sum as 'sum'
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class RootToLeafPath {

  public boolean hasPath(BSTNode root, int sum) {
    if (root == null) {
      // If a tree is null, then sum should also be null
      return sum == 0;
    }
    int subtractedSum = sum - root.data;
    if (root.left == null && root.right == null) {
      // If we have reached a leaf node, subtracted sum should be zero now
      return subtractedSum == 0;
    } else {
      // If left child exists, recurse and see if the condition becomes true
      if (root.left != null && hasPath(root.left, subtractedSum)) {
        return true;
      } else if (root.right != null && hasPath(root.right, subtractedSum)) {
        // Same for right subtree
        return true;
      } else {
        // If none of the above conditions are true, return false
        return false;
      }
    }
  }
}
