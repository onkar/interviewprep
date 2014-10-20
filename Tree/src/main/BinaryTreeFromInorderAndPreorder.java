package main;

import main.BinarySearchTree.BSTNode;

public class BinaryTreeFromInorderAndPreorder {
  private final int[] inorder;
  private final int[] preorder;
  int preIndex;

  public BinaryTreeFromInorderAndPreorder(int[] inorder, int[] preorder) {
    this.inorder = inorder;
    this.preorder = preorder;
    preIndex = 0;
  }

  public BSTNode constructBinaryTree() {
    return constructBinaryTreeUtil(0, inorder.length - 1);
  }

  private BSTNode constructBinaryTreeUtil(int low, int high) {
    if (low > high) {
      return null;
    }
    // Create the root node from the first element of preorder
    BSTNode root = new BSTNode(preorder[preIndex]);
    // Increment preIndex so that the next recursive call will pick the next element as the root of
    // the subtree
    preIndex++;
    // Exit condition, if there is only one element remaining
    if (low == high) {
      return root;
    }
    int i;
    // Search the root's data in the inorder array and when found, break.
    for (i = low; i <= high; i++) {
      if (root.data == inorder[i]) {
        break;
      }
    }
    // Recursively call into left subtree and right subtree based on the index i found before
    root.left = constructBinaryTreeUtil(low, i - 1);
    root.right = constructBinaryTreeUtil(i + 1, high);
    // Return the constructed root
    return root;
  }

}
