package test;

import junit.framework.Assert;
import main.BinarySearchTree.BSTNode;
import main.DiameterOfBinaryTree;

import org.junit.Test;

public class DiameterOfBinaryTreeTest {

  @Test
  public void test() {
    BSTNode root = new BSTNode(5);
    root.left = new BSTNode(1);
    root.right = new BSTNode(8);
    root.left.right = new BSTNode(3);
    root.right.left = new BSTNode(6);
    root.right.right = new BSTNode(9);
    DiameterOfBinaryTree dbt = new DiameterOfBinaryTree();
    Assert.assertEquals(5, dbt.getDiameter(root));
    Assert.assertEquals(5, dbt.getDiameterOptimized(root));
  }
}
