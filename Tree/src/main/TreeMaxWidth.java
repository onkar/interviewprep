package main;

import java.util.LinkedList;
import java.util.Queue;

import main.BinarySearchTree.BSTNode;

/**
 * Return the maximum width of a binary tree. The maximum width for the following tree is 3, which
 * include nodes (4, 5, 8).
 * 
 * <pre>
 *                     1
 *                   /   \
 *                  2     3
 *                /  \     \
 *               4    5     8
 *                         /  \
 *                        6    7
 * </pre>
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class TreeMaxWidth {
  // Array to keep track of number of nodes at given level
  private int[] count;

  public int getMaxWidth(BSTNode root) {
    int height = getHeight(root);
    // No. of elements in the array are equal to the height of the tree
    count = new int[height];
    getMaxWidthRec(root, 0);

    // Find the maximum count and return it
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < count.length; i++) {
      if (count[i] > max) {
        max = count[i];
      }
    }
    return max;
  }

  // Do a preorder traversal and instead of printing the level, increment the count array at the
  // level index.
  private void getMaxWidthRec(BSTNode root, int level) {
    if (root == null) {
      return;
    }
    count[level]++;
    getMaxWidthRec(root.left, level + 1);
    getMaxWidthRec(root.right, level + 1);
  }

  // Calculate the height of the tree
  private int getHeight(BSTNode root) {
    if (root == null) {
      return 0;
    }
    int leftHeight = getHeight(root.left);
    int rightHeight = getHeight(root.right);
    if (leftHeight > rightHeight) {
      return 1 + leftHeight;
    } else {
      return 1 + rightHeight;
    }
  }

  public int getMaxWidthIterative(BSTNode root) {
    if (root == null)
      return 0;

    Queue<BSTNode> queue = new LinkedList<BSTNode>();
    queue.add(root);
    int maxWidth = Integer.MIN_VALUE;
    while (!queue.isEmpty()) {
      int nodesAtLevel = queue.size();
      if (nodesAtLevel > maxWidth)
        maxWidth = nodesAtLevel;

      while (nodesAtLevel > 0) {
        BSTNode node = queue.remove();
        if (node.left != null)
          queue.add(node.left);
        if (node.right != null)
          queue.add(node.right);
        --nodesAtLevel;
      }
    }
    return maxWidth;
  }
}
