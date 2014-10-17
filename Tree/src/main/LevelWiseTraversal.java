package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import main.BinarySearchTree.BSTNode;

/**
 * Return level wise traversal of a binary search tree
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class LevelWiseTraversal {
  private final BSTNode root;

  public LevelWiseTraversal(BSTNode root) {
    this.root = root;
  }

  public List<Integer> levelWise() {
    if (root == null) {
      return null;
    }
    // list to hold level wise elements
    List<Integer> list = new ArrayList<Integer>();
    list.add(root.data);

    Queue<BSTNode> queue = new LinkedList<BSTNode>();

    BSTNode temp = root;
    while (temp != null) {
      if (temp.left != null) {
        // Put left child in the queue and data in the list
        queue.add(temp.left);
        list.add(temp.left.data);
      }
      if (temp.right != null) {
        // Put right child in the queue and data in the list
        queue.add(temp.right);
        list.add(temp.right.data);
      }
      // Remove and assign the popped element of the queue
      temp = queue.poll();
    }
    return list;
  }

  public List<Integer> levelWiseRecursive() {
    List<Integer> l = new ArrayList<Integer>();
    int height = getHeight(root);
    // For level wise, not that for loop is normal (from 0 to height)
    for (int i = 1; i <= height; i++) {
      levelWiseRecursiveUtil(root, i, l);
    }
    return l;
  }

  private void levelWiseRecursiveUtil(BSTNode root, int h, List<Integer> l) {
    if (root == null) {
      return;
    }
    if (h == 1) {
      l.add(root.data);
    } else if (h > 1) {
      levelWiseRecursiveUtil(root.left, h - 1, l);
      levelWiseRecursiveUtil(root.right, h - 1, l);
    }
  }

  private int getHeight(BSTNode root) {
    if (root == null) {
      return 0;
    } else {
      int leftHeight = getHeight(root.left);
      int rightHeight = getHeight(root.right);
      if (leftHeight > rightHeight) {
        return leftHeight + 1;
      } else {
        return rightHeight + 1;
      }
    }
  }

  public List<Integer> reverseLevelWise() {
    List<Integer> l = new ArrayList<Integer>();
    int height = getHeight(root);
    // For reverse, note that for loop is also reversed
    for (int i = height; i >= 1; i--) {
      levelWiseRecursiveUtil(root, i, l);
    }
    return l;
  }

  public List<Integer> spiralLevelWise() {
    List<Integer> l = new ArrayList<Integer>();
    if (root == null) {
      return null;
    }
    // Create two stacks, s1 is for storing elements to be printed from right to left. s2 is for
    // storing elements to be printed from left to right.
    Stack<BSTNode> s1 = new Stack<BSTNode>();
    Stack<BSTNode> s2 = new Stack<BSTNode>();

    // Push root to s1
    s1.push(root);

    // Run until any of the stacks doesn't become empty
    while (!s1.isEmpty() || !s2.isEmpty()) {
      while (!s1.isEmpty()) {
        BSTNode temp = s1.pop();
        l.add(temp.data);
        // Note that since s2 should be used to print from left to right, the right element is
        // pushed first and then left element is pushed. So when we pop from s2, we will get the
        // left element first and then the right element
        if (temp.right != null) {
          s2.add(temp.right);
        }
        if (temp.left != null) {
          s2.add(temp.left);
        }
      }

      while (!s2.isEmpty()) {
        BSTNode temp = s2.pop();
        l.add(temp.data);
        // Since s1 is used for printing from right to left, left element is pushed first
        if (temp.left != null) {
          s1.add(temp.left);
        }
        if (temp.right != null) {
          s1.add(temp.right);
        }
      }
    }
    return l;
  }
}
