package main;

import java.util.LinkedList;
import java.util.Queue;

import main.BinarySearchTree.BSTNode;

/**
 * Write a function that when given an array converts it to a binary tree representation.
 * 
 * <pre>
 * Input : [7, 3, 9, 2, 4, 8, 10]
 * Output :
 *                    7
 *                  /   \
 *                 3     9
 *                / \   / \
 *               2  4  8  10
 * </pre>
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 *
 */
public class ArrayToBinaryTree {

  public static BSTNode convert(int[] array) {
    BSTNode root = new BSTNode(array[0]);
    Queue<BSTNode> queue = new LinkedList<BSTNode>();
    queue.add(root);
    int currentLevel = 0, leftIndex, rightIndex;
    BSTNode node = root;
    while (!queue.isEmpty()) {
      leftIndex = 2 * currentLevel + 1;
      rightIndex = 2 * currentLevel + 2;
      node = queue.poll();
      if (leftIndex < array.length) {
        node.left = new BSTNode(array[leftIndex]);
        queue.add(node.left);
      } else {
        node.left = null;
      }

      if (rightIndex < array.length) {
        node.right = new BSTNode(array[rightIndex]);
        queue.add(node.right);
      } else {
        node.right = null;
      }
      ++currentLevel;
    }
    return root;
  }
}
