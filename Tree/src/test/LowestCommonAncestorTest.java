package test;


import main.BinarySearchTree;
import main.BinarySearchTree.BSTNode;
import main.LowestCommonAncestor;

import org.junit.Assert;
import org.junit.Test;

public class LowestCommonAncestorTest {
  @Test
  public void testBinaryTree() {
    BSTNode root = new BSTNode(3);
    root.left = new BSTNode(5);
    root.right = new BSTNode(1);
    root.left.left = new BSTNode(6);
    root.left.right = new BSTNode(2);
    root.left.right.left = new BSTNode(7);
    root.left.right.right = new BSTNode(4);
    root.right.left = new BSTNode(0);
    root.right.right = new BSTNode(8);

    LowestCommonAncestor lca = new LowestCommonAncestor();
    Assert.assertEquals(5, lca.findLCAOfBinaryTree(root, root.left.left, root.left.right).data);
  }

  @Test
  public void testBinarySearchTree() {
    BinarySearchTree bst = new BinarySearchTree();
    bst.insert(6);
    bst.insert(2);
    bst.insert(8);
    bst.insert(0);
    bst.insert(4);
    bst.insert(7);
    bst.insert(9);
    bst.insert(3);
    bst.insert(5);

    LowestCommonAncestor lca = new LowestCommonAncestor();
    Assert
        .assertEquals(8, lca.findLCAOfBinarySearchTree(bst.root(), bst.root().right.left,
            bst.root().right.right).data);

  }
}
