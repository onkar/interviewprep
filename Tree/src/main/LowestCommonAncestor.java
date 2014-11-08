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
  public BSTNode findLCAOfBinaryTree(BSTNode root, BSTNode p, BSTNode q) {
    if (root == null)
      return null;
    if (root == p || root == q)
      return root;
    BSTNode left = findLCAOfBinaryTree(root.left, p, q);
    BSTNode right = findLCAOfBinaryTree(root.right, p, q);
    if (left != null && right != null)
      return root;
    return (left != null) ? left : right;
  }

  /**
   * Need to handle these 4 cases -
   * 
   * <pre>
   * 1. Both nodes are to the left of the tree. 
   * 2. Both nodes are to the right of the tree. 
   * 3. One node is on the left while the other is on the right.
   * 4. When the current node equals to either of the two nodes, this node must be the LCA too.
   * </pre>
   * 
   * @param root
   * @param p
   * @param q
   * @return
   */
  public BSTNode findLCAOfBinarySearchTree(BSTNode root, BSTNode p, BSTNode q) {
    if (root == null) {
      return null;
    }
    if (p == null || q == null) {
      return null;
    }
    if (Math.max(p.data, q.data) < root.data)
      return findLCAOfBinarySearchTree(root.left, p, q);
    else if (Math.min(p.data, q.data) > root.data)
      return findLCAOfBinarySearchTree(root.right, p, q);
    else
      return root;
  }
}
