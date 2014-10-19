package main;

import main.BinarySearchTree.BSTNode;

/**
 * Create a binary tree from postorder and preorder traversals
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class BinaryTreeFromPreorderAndPostorder {
  private final int[] preorder;
  private final int[] postorder;
  private int preIndex;

  public BinaryTreeFromPreorderAndPostorder(int[] preorder, int[] postorder) {
    this.preorder = preorder;
    this.postorder = postorder;
    this.preIndex = 0;
  }

  public BSTNode constructBinaryTree() {
    return constructBTUtil(0, preorder.length - 1, preorder.length);
  }

  private BSTNode constructBTUtil(int low, int high, int size) {
    if (preIndex >= size || low > high) {
      return null;
    }
    // Since first element of the preorder sequence is always root, create the root node
    BSTNode root = new BSTNode(preorder[preIndex]);
    // Increment preindex since we've already read the first element
    preIndex++;
    // This is an exit condition, when there is only one element present in the recursion or when
    // the preIndex has reached the size
    if (low == high || preIndex == size) {
      return root;
    }
    int i;
    // Find the root element in the postorder array and when found, break
    for (i = low; i <= high; i++) {
      if (preorder[preIndex] == postorder[i]) {
        break;
      }
    }
    // Now i has the index of the element in the postorder
    if (i <= high) {
      // Recursively call on the left subtree and right subtree
      root.left = constructBTUtil(low, i, size);
      root.right = constructBTUtil(i + 1, high, size);
    }
    return root;
  }
}
