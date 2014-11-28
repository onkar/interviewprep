package main;

import java.util.LinkedList;
import java.util.Queue;

import main.BinarySearchTree.BSTNode;

public class MinHeightOfBinaryTree {
  // Basically, do a BFS on the tree and return the count when a leaf node is found
  public int getMinHeight(BSTNode root) {
    if (root == null)
      return 0;
    Queue<BSTNode> nodes = new LinkedList<BSTNode>();
    Queue<Integer> counts = new LinkedList<Integer>();
    nodes.add(root);
    counts.add(1);
    while (!nodes.isEmpty()) {
      BSTNode node = nodes.remove();
      int count = counts.remove();
      if (node.left != null) {
        nodes.add(node.left);
        counts.add(count + 1);
      }
      if (node.right != null) {
        nodes.add(node.right);
        counts.add(count + 1);
      }
      if (node.left == null && node.right == null) {
        return count;
      }
    }
    return 0;
  }
}
