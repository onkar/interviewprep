package main;

import main.BinarySearchTree.BSTNode;

public class LowestCommonAncestor {

  /**
   * We traverse from the bottom, and once we reach a node which matches one of the two nodes, we
   * pass it up to its parent. The parent would then test its left and right subtree if each contain
   * one of the two nodes. If yes, then the parent must be the LCA and we pass its parent up to the
   * root. If not, we pass the lower node which contains either one of the two nodes (if the left or
   * right subtree contains either p or q), or NULL (if both the left and right subtree does not
   * contain either p or q) up.
   * 
   * @param root
   * @param p
   * @param q
   * @return
   */
  public BSTNode findLCA(BSTNode root, BSTNode p, BSTNode q) {
    if (root == null)
      return null;
    if (root == p || root == q)
      return root;
    BSTNode left = findLCA(root.left, p, q);
    BSTNode right = findLCA(root.right, p, q);
    if (left != null && right != null)
      return root;
    return (left != null) ? left : right;
  }

}
