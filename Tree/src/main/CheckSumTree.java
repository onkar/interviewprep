package main;

import main.BinarySearchTree.BSTNode;

/**
 * Check if the given tree is a sum tree.
 * 
 * <pre>
 *                 115
 *                /  \
 *             45     25
 *            /  \
 *          30   15
 * </pre>
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class CheckSumTree {

  // O(n^2) in worst case (skewed tree case) algorithm.
  public boolean checkIfSumTree(BSTNode root) {
    if (root == null || (root.left == null && root.right == null)) {
      return true;
    }
    int leftSum = calculateSum(root.left);
    int rightSum = calculateSum(root.right);
    return (root.data == leftSum + rightSum) && checkIfSumTree(root.left)
        && checkIfSumTree(root.right);
  }

  private int calculateSum(BSTNode node) {
    if (node == null) {
      return 0;
    }
    return node.data + calculateSum(node.left) + calculateSum(node.right);
  }

  // O(n) algorithm
  public boolean checkIfSumTreeBetter(BSTNode root) {
    if (root == null || isLeaf(root)) {
      return true;
    }
    int leftSum, rightSum;
    if (checkIfSumTreeBetter(root.left) && checkIfSumTreeBetter(root.right)) {
      if (root.left == null) {
        // If there is no left child, there is no leftSum
        leftSum = 0;
      } else if (isLeaf(root.left)) {
        // If the left child is a leaf node, leftSum is the data of the left child
        leftSum = root.left.data;
      } else {
        // If the left child is a non-leaf node, leftSum is twice the data of the left child. If
        // this tree is a sum tree, this assumption will be true. Check the node with value 45 in
        // the above diagram.
        leftSum = 2 * root.left.data;
      }

      // Same for the right side
      if (root.right == null) {
        rightSum = 0;
      } else if (isLeaf(root.right)) {
        rightSum = root.right.data;
      } else {
        rightSum = 2 * root.right.data;
      }

      // If root's data matches the sum of left child and right child, return true
      return root.data == leftSum + rightSum;
    }
    return false;
  }

  boolean isLeaf(BSTNode node) {
    return node.left == null && node.right == null;
  }
}
