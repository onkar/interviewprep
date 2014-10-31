package main;

import main.BinarySearchTree.BSTNode;

/**
 * Given a binary search tree and a value k, please find a node in the binary search tree whose
 * value is closest to k.
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class ClosestNodeInBST {
  public BSTNode getClosestNode(BSTNode root, int k) {
    BSTNode node = root;
    // Initialize closest node to null
    BSTNode closestNode = null;
    // The idea is to compute the minimum difference between node's value and k. Each time a node is
    // found with even less distance, we update the minimum distance and closest node.
    int minDistance = Integer.MAX_VALUE;
    while (node != null) {
      // Subtract current node's data from k to get the distance
      int distance = Math.abs(node.data - k);
      // Update the minimum distance and closest node
      if (distance < minDistance) {
        minDistance = distance;
        closestNode = node;
      }
      // If distance becomes zero, break and return closestNode
      if (distance == 0) {
        break;
      }
      // If node's data is greater than k, then distance between nodes in the right subtree is even
      // greater so no point in going in right subtree. Recurse to left subtree.
      if (node.data > k) {
        node = node.left;
      } else if (node.data < k) {
        // Similarly, recurse to right subtree
        node = node.right;
      }
    }
    return closestNode;
  }
}
