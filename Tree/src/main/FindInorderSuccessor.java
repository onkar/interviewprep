package main;

import main.BinarySearchTree.BSTNode;

/**
 * Set the inorder successor of node 'node' in a tree rooted at 'root.
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class FindInorderSuccessor {

  public BSTNode getInorderSuccessor(BSTNode root, BSTNode node) {
    if (node.right != null) {
      // If the right subtree exists, find the smallest number in it
      return findSmallest(node.right);
    }
    // Otherwise, scan for the inorder successor from the root
    BSTNode inorderSuccessor = null;
    while (root != null) {
      if (root.data > node.data) {
        // If root's data is greater than node's data, set root as the inorder successor and go to
        // root's left subtree to see if there's any node which can potentially become the inorder
        // successor of 'node'.
        inorderSuccessor = root;
        root = root.left;
      } else if (root.data < node.data) {
        // No need to update inorder successor since root's data is smaller that node's data.
        // Recurse into right subtree.
        root = root.right;
      } else {
        break;
      }
    }
    return inorderSuccessor;
  }

  private BSTNode findSmallest(BSTNode node) {
    while (node.left != null) {
      node = node.left;
    }
    return node;
  }
}
