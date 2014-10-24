package test;

import main.BinarySearchTree.BSTNode;
import main.CheckSubTree;

import org.junit.Assert;
import org.junit.Test;

public class CheckSubTreeTest {
  @Test
  public void test() {
    BSTNode root = new BSTNode(1);
    root.left = new BSTNode(2);
    root.right = new BSTNode(3);
    root.left.left = new BSTNode(4);
    root.left.right = new BSTNode(5);
    root.right.left = new BSTNode(6);
    root.right.right = new BSTNode(7);

    BSTNode other = new BSTNode(2);
    other.left = new BSTNode(4);
    other.right = new BSTNode(5);

    CheckSubTree cst = new CheckSubTree();
    Assert.assertTrue(cst.isSubTree(root, other));

    other = new BSTNode(1);
    other.left = new BSTNode(2);
    other.right = new BSTNode(5);
    Assert.assertFalse(cst.isSubTree(root, other));
  }
}
