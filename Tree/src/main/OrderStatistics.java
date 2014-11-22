package main;

import java.util.Stack;

import main.BinarySearchTree.BSTNode;

public class OrderStatistics {

  public BSTNode kthSmallest(BSTNode root, int k) {
    Stack<BSTNode> stack = new Stack<BSTNode>();
    // Push a sentinel node
    stack.push(null);
    BSTNode temp = root;
    while (temp != null) {
      stack.push(temp);
      // Keep pushing left subtree
      temp = temp.left;
    }
    while (!stack.isEmpty() && stack.peek() != null) {
      // Pop the stack and decrement k. If k becomes zero, break and return temp
      temp = stack.pop();
      if (--k == 0) {
        break;
      }

      if (temp.right != null) {
        // If a node has right subtree, push it and push all of it's left children
        temp = temp.right;
        while (temp != null) {
          stack.push(temp);
          temp = temp.left;
        }
      }
    }
    return temp;
  }

  public BSTNode kthLargest(BSTNode root, int k) {
    Stack<BSTNode> stack = new Stack<BSTNode>();
    stack.push(null);
    BSTNode temp = root;
    while (temp != null) {
      stack.push(temp);
      temp = temp.right;
    }
    while (!stack.isEmpty() && stack.peek() != null) {
      temp = stack.pop();
      if (--k == 0) {
        break;
      }
      if (temp.left != null) {
        temp = temp.left;
        while (temp != null) {
          stack.push(temp);
          temp = temp.right;
        }
      }
    }
    return temp;
  }
}
