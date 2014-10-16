package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
}
