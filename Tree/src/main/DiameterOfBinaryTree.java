package main;

import main.BinarySearchTree.BSTNode;

public class DiameterOfBinaryTree {

  // O(n^2) implementation because getHeight is called in a recursion
  public int getDiameter(BSTNode root) {
    if (root == null) {
      return 0;
    }
    int leftHeight = getHeight(root.left);
    int rightHeight = getHeight(root.right);
    int leftDiameter = getDiameter(root.left);
    int rightDiameter = getDiameter(root.right);
    return Math.max(leftHeight + rightHeight + 1, Math.max(leftDiameter, rightDiameter));
  }

  private int getHeight(BSTNode root) {
    if (root == null) {
      return 0;
    }
    int lh = getHeight(root.left);
    int rh = getHeight(root.right);
    if (lh > rh) {
      return 1 + lh;
    } else {
      return 1 + rh;
    }
  }

  // O(n) solution
  // Wrapper class for holding a reference to height
  private class HeightWrapper {
    private int height = 0;
  }

  private int getDiameterOptimizedHelper(BSTNode root, HeightWrapper heightWrapper) {
    if (root == null) {
      // If root is null, diameter is 0.
      return 0;
    }
    HeightWrapper lhw = new HeightWrapper();
    HeightWrapper rhw = new HeightWrapper();

    // Recurse in left and right subtrees
    int leftDiameter = getDiameterOptimizedHelper(root.left, lhw);
    int rightDiameter = getDiameterOptimizedHelper(root.right, rhw);

    heightWrapper.height = Math.max(lhw.height, rhw.height) + 1;

    return Math.max(lhw.height + rhw.height + 1, Math.max(leftDiameter, rightDiameter));
  }

  public int getDiameterOptimized(BSTNode root) {
    HeightWrapper heightWrapper = new HeightWrapper();
    return getDiameterOptimizedHelper(root, heightWrapper);
  }
}
