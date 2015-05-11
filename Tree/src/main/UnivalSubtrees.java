package main;

import main.BinarySearchTree.BSTNode;

/**
 * Given a binary tree, we need to count the number of unival subtrees (all nodes have same value).
 * Source - https://crazycoderzz.wordpress.com/count-the-number-of-unival-subtrees-in-a-binary-tree/
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 *
 */
public class UnivalSubtrees {
  private static class Count {
    int counter;

    public Count(int counter) {
      this.counter = counter;
    }
  }

  public static int count(BSTNode root) {
    Count count = new Count(0);
    countRecursive(root, count);
    return count.counter;
  }

  private static boolean countRecursive(BSTNode root, Count count) {
    if (root == null)
      return true;

    boolean left = countRecursive(root.left, count);
    boolean right = countRecursive(root.right, count);

    if (left && right) {
      BSTNode leftChild = root.left;
      BSTNode rightChild = root.right;

      if (leftChild == null && rightChild == null) {
        // Every leaf node is a unival subtree
        count.counter += 1;
        return true;
      }

      if (leftChild != null && rightChild != null && root.data == leftChild.data
          && root.data == rightChild.data) {
        // Non-leaf node with two children and both children's data match with root's data
        count.counter += 1;
        return true;
      }

      if (leftChild != null && root.data == leftChild.data) {
        // Left child present and its data matches root's data
        count.counter += 1;
        return true;
      }

      if (rightChild != null && root.data == rightChild.data) {
        // Right child present and its data matches root's data
        count.counter += 1;
        return true;
      }
    }
    return false;
  }
}
