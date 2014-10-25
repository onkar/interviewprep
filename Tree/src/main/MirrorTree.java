package main;

import main.BinarySearchTree.BSTNode;

/**
 * Mirror a given binary tree
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class MirrorTree {
  // Do a post order traversal and instead of printing node, swap left and right children
  public void doMirror(BSTNode root) {
    if (root == null) {
      return;
    }
    doMirror(root.left);
    doMirror(root.right);
    BSTNode temp = root.left;
    root.left = root.right;
    root.right = temp;
  }
}
