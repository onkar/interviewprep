package test;

import main.BalancedBinaryTree;
import main.BinarySearchTree.BSTNode;

import org.junit.Assert;
import org.junit.Test;

public class BalancedBinaryTreeTest {
  @Test
  public void test() {
    BSTNode root = new BSTNode(1);
    root.left = new BSTNode(2);
    root.right = new BSTNode(3);
    root.left.left = new BSTNode(4);
    root.left.right = new BSTNode(5);
    root.right.left = new BSTNode(6);
    root.left.left.left = new BSTNode(7);
    BalancedBinaryTree bbt = new BalancedBinaryTree();
    Assert.assertTrue(bbt.isBalanced(root));
    Assert.assertTrue(bbt.isBalancedBetter(root));
  }

}
