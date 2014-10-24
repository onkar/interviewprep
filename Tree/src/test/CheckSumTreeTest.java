package test;

import main.BinarySearchTree.BSTNode;
import main.CheckSumTree;

import org.junit.Assert;
import org.junit.Test;

public class CheckSumTreeTest {

  @Test
  public void test() {
    BSTNode root = new BSTNode(115);
    root.right = new BSTNode(25);
    root.left = new BSTNode(45);
    root.left.left = new BSTNode(30);
    root.left.right = new BSTNode(15);
    CheckSumTree cst = new CheckSumTree();
    Assert.assertTrue(cst.checkIfSumTree(root));
    Assert.assertTrue(cst.checkIfSumTreeBetter(root));
  }
}
