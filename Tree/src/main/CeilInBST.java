package main;

import main.BinarySearchTree.BSTNode;

public class CeilInBST {

  public int getCeil(BSTNode root, int key) {
    if (root == null) {
      // If no ceil for the given key is found, return -1
      return -1;
    }
    if (root.data == key) {
      // Key found, so return key as the ceil
      return key;
    } else if (root.data > key) {
      // At this moment, root.data could be the ceil value. Or there could be a ceil value in the
      // left subtree. So, we call recursively on the left subtree and get the result. If result is
      // -1, then it means that there is no ceil found in the left subtree, so then current node's
      // data is the ceil value. If however, a valid ceil (something other than -1) is found, we
      // return that as the result.
      int result = getCeil(root.left, key);
      return result == -1 ? root.data : result;
    } else {
      // Recurse in right subtree
      return getCeil(root.right, key);
    }
  }

}
