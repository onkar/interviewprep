package main;

import java.util.ArrayList;
import java.util.List;

/**
 * Operations related to binary search tree.
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class BinarySearchTree {

  // Basic data structure for a binary tree
  public static class BSTNode {
    public BSTNode left;
    public BSTNode right;
    public int data;

    public BSTNode() {
      this.left = null;
      this.right = null;
      this.data = 0;
    }

    public BSTNode(int data) {
      this.left = null;
      this.right = null;
      this.data = data;
    }
  }

  private BSTNode root;

  public BinarySearchTree() {
    this.root = null;
  }

  public BinarySearchTree(BSTNode root) {
    this.root = root;
  }

  public BSTNode root() {
    return this.root;
  }

  public void insert(int data) {
    this.root = insert(root, data);
  }

  private BSTNode insert(BSTNode node, int data) {
    if (node == null) {
      node = new BSTNode(data);
    } else {
      if (data <= node.data) {
        // Make sure that returned value from recursion is assigned to node.left
        node.left = insert(node.left, data);
      } else {
        // Make sure that returned value from recursion is assigned to node.right
        node.right = insert(node.right, data);
      }
    }
    return node;
  }

  public void delete(int val) {
    if (this.root == null) {
      return;
    } else if (!search(val)) {
      // Returned if value is not found in the tree
      return;
    } else {
      this.root = delete(this.root, val);
    }
  }

  private BSTNode delete(BSTNode node, int val) {
    if (node == null) {
      return null;
    } else if (val < node.data) {
      // Assign delete's returned value to node.left
      node.left = delete(node.left, val);
    } else if (val > node.data) {
      // Assign delete's returned value to node.right
      node.right = delete(node.right, val);
    } else {
      // Delete the node now...
      // Case 1 : No child
      if (node.left == null && node.right == null) {
        node = null;
      } else if (node.left == null) {
        // Case 2: Right child
        node = node.right;
      } else if (node.right == null) {
        // Case 2: Left child
        node = node.left;
      } else {
        // Case 3: Two children. Find the minimum node in the right subtree, copy its data into
        // node's data and then recursively delete node's right node which has the same value as
        // minimum value
        BSTNode minInRightSubtree = findMin(node.right);
        node.data = minInRightSubtree.data;
        node.right = delete(node.right, minInRightSubtree.data);
      }
    }
    return node;
  }

  private BSTNode findMin(BSTNode minNode) {
    while (minNode.left != null) {
      minNode = minNode.left;
    }
    return minNode;
  }

  private boolean search(int val) {
    return search(this.root, val);
  }

  private boolean search(BSTNode node, int val) {
    boolean found = false;
    while (node != null && !found) {
      if (val < node.data) {
        return search(node.left, val);
      } else if (val > node.data) {
        return search(node.right, val);
      } else {
        found = true;
        break;
      }
    }
    return found;
  }

  public List<Integer> inorder() {
    List<Integer> list = new ArrayList<Integer>();
    inorder(root, list);
    return list;
  }

  private void inorder(BSTNode root, List<Integer> list) {
    if (root == null) {
      return;
    } else {
      inorder(root.left, list);
      list.add(root.data);
      inorder(root.right, list);
    }
  }

  public List<Integer> preorder() {
    List<Integer> list = new ArrayList<Integer>();
    preorder(root, list);
    return list;
  }

  private void preorder(BSTNode root, List<Integer> list) {
    if (root == null) {
      return;
    } else {
      list.add(root.data);
      preorder(root.left, list);
      preorder(root.right, list);
    }
  }

  public List<Integer> postorder() {
    List<Integer> list = new ArrayList<Integer>();
    postorder(root, list);
    return list;
  }

  private void postorder(BSTNode root, List<Integer> list) {
    if (root == null) {
      return;
    } else {
      postorder(root.left, list);
      postorder(root.right, list);
      list.add(root.data);
    }
  }
}
