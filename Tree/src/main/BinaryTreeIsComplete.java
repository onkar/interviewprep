package main;

import java.util.LinkedList;
import java.util.Queue;

import main.BinarySearchTree.BSTNode;

/**
 * <pre>
 * Return if a binary tree is a complete binary tree. A binary tree is complete if all leaf nodes
 * are at same level and there are no holes in the tree. For example, this is a complete binary tree -
 *               A
 *             /   \
 *            B     C
 *          /  \   /  \
 *         D   E   F   G
 * </pre>
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class BinaryTreeIsComplete {
  public boolean isBinaryTreeComplete(BSTNode root) {
    if (root == null) {
      return true;
    }
    int count = 0;
    Queue<BSTNode> queue = new LinkedList<BSTNode>();
    count++;
    BSTNode temp = root;
    while (temp != null) {
      // If a node doesn't have a left child, break.
      if (temp.left == null) {
        break;
      }
      // If a node has a left child but doesn't have right child, break.
      if (temp.left != null && temp.right == null) {
        break;
      }
      // If a node has a left child, add it to the queue and increment the counter. Basically do
      // BFS.
      if (temp.left != null) {
        queue.add(temp.left);
        count++;
      }
      // Same for the right child.
      if (temp.right != null) {
        queue.add(temp.right);
        count++;
      }
      temp = queue.poll();
    }

    // Count the number of nodes in the original tree and compare with the count gathered in the
    // above BFS. If they match, the tree is a complete binary tree else it is not.
    int noOfElements = countNodes(root);
    if (noOfElements == count) {
      return true;
    } else {
      return false;
    }
  }

  private int countNodes(BSTNode root) {
    if (root == null) {
      return 0;
    } else {
      return 1 + countNodes(root.left) + countNodes(root.right);
    }
  }
}
