package main;

import java.util.Stack;

import main.BinarySearchTree.BSTNode;

/**
 * Given a binary search tree, please check whether there are two nodes in it whose sum equals a
 * given value.
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class NodesWithGivenSum {
  /**
   * Use similar logic as "Given the sum, find out two numbers in the array that adds to this sum"
   * problem. We have two pointers (leftmost child and rightmost child) and that can act as the
   * beginning and ending of the array. The trick is to get the next and previous pointers in the
   * tree.
   * 
   * @param root
   * @param sum
   * @return
   */
  public boolean hasTwoNodes(BSTNode root, int sum) {
    // Keep stacks for next and previous nodes
    Stack<BSTNode> nextNodesStack = new Stack<BSTNode>();
    Stack<BSTNode> prevNodesStack = new Stack<BSTNode>();

    // Build the stacks
    buildNextNodes(root, nextNodesStack);
    buildPrevNodes(root, prevNodesStack);

    // Get the next and prev nodes from the stacks
    BSTNode next = getNextNode(nextNodesStack);
    BSTNode prev = getPrevNode(prevNodesStack);

    // Use similar logic as array
    while (next != null && prev != null && prev != next) {
      int currentSum = next.data + prev.data;
      if (currentSum == sum) {
        // We found the sum, return true
        return true;
      }
      if (currentSum < sum) {
        // Increment the next pointer
        next = getNextNode(nextNodesStack);
      } else {
        // Decrement the prev pointer
        prev = getPrevNode(prevNodesStack);
      }
    }
    return false;
  }

  // Use exactly reverse logic of getNextNode()
  private BSTNode getPrevNode(Stack<BSTNode> prevNodesStack) {
    BSTNode prev = null;
    if (!prevNodesStack.isEmpty()) {
      prev = prevNodesStack.pop();
      BSTNode leftChild = prev.left;
      while (leftChild != null) {
        prevNodesStack.add(leftChild);
        leftChild = leftChild.right;
      }
    }
    return prev;
  }

  private BSTNode getNextNode(Stack<BSTNode> nextNodesStack) {
    BSTNode next = null;
    if (!nextNodesStack.isEmpty()) {
      // Pop the element and set it to next. For first iteration, next will point to the leftmost
      // leaf node
      next = nextNodesStack.pop();
      BSTNode rightChild = next.right;
      // If the next node has a right child, push it to the stack and move to it's left child. If
      // the node doesn't have a right child, returned the last popped element
      while (rightChild != null) {
        nextNodesStack.add(rightChild);
        rightChild = rightChild.left;
      }
    }
    return next;
  }

  // Traverse left until leaf node is reached and in each step, push the node in the stack
  private void buildNextNodes(BSTNode root, Stack<BSTNode> nextNodesStack) {
    BSTNode temp = root;
    while (temp != null) {
      nextNodesStack.add(temp);
      temp = temp.left;
    }
  }

  // Traverse right until leaf node is reached and in each step, push the node in the stack
  private void buildPrevNodes(BSTNode root, Stack<BSTNode> prevNodesStack) {
    BSTNode temp = root;
    while (temp != null) {
      prevNodesStack.add(temp);
      temp = temp.right;
    }
  }
}
