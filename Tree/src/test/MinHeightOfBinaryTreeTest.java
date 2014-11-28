package test;

import main.BinarySearchTree.BSTNode;
import main.MinHeightOfBinaryTree;

import org.junit.Assert;
import org.junit.Test;

public class MinHeightOfBinaryTreeTest {
  @Test
  public void test() {
    BSTNode root = new BSTNode(1);
    root.left = new BSTNode(4);
    root.right = new BSTNode(7);
    root.right.left = new BSTNode(5);
    root.right.right = new BSTNode(15);
    MinHeightOfBinaryTree mb = new MinHeightOfBinaryTree();
    Assert.assertEquals(2, mb.getMinHeight(root));
  }
}
