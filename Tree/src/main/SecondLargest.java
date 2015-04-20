package main;

import main.BinarySearchTree.BSTNode;

/**
 * Return second largest element in the binary search tree
 * 
 * For example, this should return 11
 * 
 * <pre>
 *              5
 *             / \
 *            3    8
 *           / \  / \
 *          1  4  7  12
 *                  /
 *                 10
 *                /  \
 *               9    11
 * </pre>
 * 
 * And if 5 only had a left child 3, it should return 3
 * 
 * And this should return Integer.MAX_VALUE
 * 
 * <pre>
 *          5
 *         / \
 * </pre>
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 *
 */
public class SecondLargest {
  public static int get(BSTNode root) {
    int secondLargest = 0;
    // Keep a previous and current pointer
    BSTNode previous = root;
    BSTNode current = root;

    // Keep traversing the right subtree till the end. Every time when we update current, we
    // preserve the old value in previous.
    while (current.right != null) {
      previous = current;
      current = current.right;
    }
    // If the rightmost node has a left subtree
    if (current.left != null) {
      // In this situation, we know that there is a node smaller than the right most node. In above
      // diagram, previous is at 12 and current is at 10. So, current can potential become the
      // second largest element in the tree.
      current = current.left;
      while (current.right != null) {
        // If current has a right subtree, then the element in right subtree is the second largest
        // element. In above example, 11.
        current = current.right;
      }
      secondLargest = current.data;
    } else {
      // Special condition when there is only one node in the tree. We return Integer.MIN_VALUE in
      // that case.
      if (current == root && previous == root) {
        secondLargest = Integer.MIN_VALUE;
      } else {
        // If right most node does not have a left subtree, then previous points to the second
        // largest element in the BST.
        secondLargest = previous.data;
      }
    }
    return secondLargest;
  }
}
