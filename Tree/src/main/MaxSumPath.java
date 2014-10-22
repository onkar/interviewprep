package main;

import java.util.ArrayList;
import java.util.List;

import main.BinarySearchTree.BSTNode;

/**
 * Return the maximum sum from root to the leaf node, and also return the path (from leaf to the
 * root) which leads to the max sum.
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class MaxSumPath {
  BSTNode targetNode;
  int maxSum;
  List<Integer> maxSumPath;

  public MaxSumPath() {
    this.targetNode = null;
    this.maxSum = Integer.MIN_VALUE;
    this.maxSumPath = new ArrayList<Integer>();
  }

  public int getMaxSum(BSTNode root) {
    if (root == null) {
      return 0;
    }
    getTargetLeafNode(root, 0 /* Current sum */);
    return maxSum;
  }

  private void getTargetLeafNode(BSTNode root, int currentSum) {
    // Base condition
    if (root == null) {
      return;
    }
    // Add root's data to the current sum
    currentSum += root.data;
    if (root.right == null && root.left == null) {
      // If root is the leaf node and the sum gathered so far is more than max sum, update the
      // maxsum and also store root as the target node
      if (currentSum > maxSum) {
        maxSum = currentSum;
        targetNode = root;
      }
    }
    // Recurse in left and right subtrees
    getTargetLeafNode(root.left, currentSum);
    getTargetLeafNode(root.right, currentSum);
  }

  private boolean getMaxSumPathUtil(BSTNode root) {
    if (root == null) {
      return false;
    }
    // If root becomes targetNode, add it to the list. The list will have a path from target Node
    // (which is a leaf node to the root of the tree). Otherwise recurse in the left and right
    // trees.
    if (root == targetNode || getMaxSumPathUtil(root.left) || getMaxSumPathUtil(root.right)) {
      maxSumPath.add(root.data);
      return true;
    }
    return false;
  }

  public List<Integer> getMaxSumPath(BSTNode root) {
    getMaxSumPathUtil(root);
    return maxSumPath;
  }
}
