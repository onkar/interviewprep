package main;

import main.BinarySearchTree.BSTNode;

public class ConvertBSTToDLL {
  private final BSTNode root;
  private BSTNode head;
  private BSTNode prev;

  public ConvertBSTToDLL(BSTNode root) {
    this.root = root;
    // Head of the doubly linked list
    this.head = null;
    // Previous pointer, used to keep track of previous node in the doubly linked list
    this.prev = null;
  }

  public BSTNode treeToList() {
    treeToListRec(root);
    return head;
  }

  // The logic is very similar to inorder traversal with some additional tweaks in link assignment
  private void treeToListRec(BSTNode root) {
    if (root == null) {
      // Empty tree, nothing to do, return
      return;
    }
    if (root.left != null) {
      // Keep recursing into the left subtree
      treeToListRec(root.left);
    }
    // We reach here when we've finished traversing left subtree. If
    if (prev != null) {
      // If prev is not null, that means there is some previous node present. We want to connect
      // current node (root) to the right of prev to complete the link.
      prev.right = root;
    } else {
      // prev is null, meaning this is the first time we are creating the doubly linked list. So,
      // assign current node (root) to the head.
      head = root;
    }
    // We have set prev's right to current node already. But since this is a doubly linked list, we
    // need to set prev to current node's (root's) left.
    root.left = prev;
    // Now left and right links of current node (root) are set, it's time to move to the next node.
    // We do this by assigning root to prev. So that in next recursion, links will be connected.
    prev = root;
    if (root.right != null) {
      // Recurse in right subtree
      treeToListRec(root.right);
    }
  }
}
