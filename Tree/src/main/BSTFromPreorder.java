package main;

import java.util.Stack;

import main.BinarySearchTree.BSTNode;

public class BSTFromPreorder {
  private final int[] preorder;
  private BSTNode root;

  public BSTFromPreorder(int[] preorder) {
    this.preorder = preorder;
  }

  public BSTNode getBST() {
    Stack<BSTNode> stack = new Stack<BSTNode>();
    // Create the root with first element in the array. Since array is VLR traversal, root should be
    // the first element of the tree. Then push root to stack.
    root = new BSTNode(preorder[0]);
    stack.push(root);
    BSTNode temp;
    for (int i = 1; i < preorder.length; i++) {
      temp = stack.peek();
      if (temp.data > preorder[i]) {
        // Scan the array and push each smaller element to stack. Then link the smaller element to
        // the left of the current node.
        temp.left = new BSTNode(preorder[i]);
        stack.push(temp.left);
      } else {
        // If the element in array is larger than the current node, pop elements from the stack
        // until a) the stack is empty or b) stack's top has a higher element than the element in
        // the array.
        while (!stack.isEmpty() && stack.peek().data < preorder[i]) {
          temp = stack.pop();
        }
        // Attach the element in the array to the right of last popped element, and push the new
        // element on stack.
        temp.right = new BSTNode(preorder[i]);
        stack.push(temp.right);
      }
    }
    return root;
  }
}
