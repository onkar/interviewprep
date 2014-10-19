package test;

import main.BinarySearchTree;
import main.BinarySearchTree.BSTNode;
import main.BinaryTreeIsBST;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinaryTreeIsBSTTest {
  BinarySearchTree bst;

  @Before
  public void setup() {
    bst = new BinarySearchTree();
    bst.insert(12);
    bst.insert(5);
    bst.insert(15);
    bst.insert(3);
    bst.insert(7);
    bst.insert(13);
    bst.insert(17);
    bst.insert(1);
    bst.insert(9);
  }

  @Test
  public void test() {
    BinaryTreeIsBST i = new BinaryTreeIsBST();
    Assert.assertTrue(i.isBST(bst.root()));

    BSTNode invalidBST = new BSTNode(10);
    invalidBST.left = new BSTNode(5);
    invalidBST.right = new BSTNode(15);
    invalidBST.right.left = new BSTNode(6);
    invalidBST.right.right = new BSTNode(20);
    Assert.assertFalse(i.isBST(invalidBST));
  }
}
