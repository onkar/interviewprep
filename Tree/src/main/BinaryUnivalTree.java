package main;

import java.util.Stack;

import main.BinarySearchTree.BSTNode;

public class BinaryUnivalTree {
  public boolean isUnivalRecursive(BSTNode root) {
    if (root == null || root.left == null && root.right == null)
      return true;

    if (root.left != null && root.right == null && root.data == root.left.data)
      return isUnivalRecursive(root.left);

    if (root.right != null && root.left == null && root.data == root.right.data)
      return isUnivalRecursive(root.right);

    return root.data == root.left.data && root.data == root.right.data
        && isUnivalRecursive(root.left) && isUnivalRecursive(root.right);
  }

  public boolean isUnivalIterative(BSTNode root) {
    Stack<BSTNode> stack = new Stack<BSTNode>();
    stack.push(root);
    while (!stack.isEmpty()) {
      BSTNode node = stack.pop();
      if (node.data != root.data)
        return false;
      if (node.left != null)
        stack.push(node.left);
      if (node.right != null)
        stack.push(node.right);
    }
    return true;
  }

  public static int count;

  public boolean getUnivalSubtrees(BSTNode root) {
    if (root == null)
      return true;
    boolean left = getUnivalSubtrees(root.left);
    boolean right = getUnivalSubtrees(root.right);
    if (left && right && (root.left == null || root.left.data == root.data)
        && (root.right == null || root.right.data == root.data)) {
      count++;
      return true;
    } else {
      return false;
    }

  }
}
