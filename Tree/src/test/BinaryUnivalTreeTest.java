package test;

import main.BinarySearchTree.BSTNode;
import main.BinaryUnivalTree;

import org.junit.Assert;
import org.junit.Test;

public class BinaryUnivalTreeTest {
  @Test
  public void test() {
    BSTNode root = new BSTNode(1);
    root.left = new BSTNode(1);
    root.right = new BSTNode(1);
    BinaryUnivalTree bu = new BinaryUnivalTree();
    Assert.assertTrue(bu.isUnival(root));
    Assert.assertTrue(bu.getUnivalSubtrees(root));
    Assert.assertEquals(3, BinaryUnivalTree.count);

    BinaryUnivalTree.count = 0;
    root = new BSTNode(1);
    root.left = new BSTNode(2);
    root.right = new BSTNode(3);
    Assert.assertFalse(bu.isUnival(root));
    Assert.assertFalse(bu.getUnivalSubtrees(root));
    Assert.assertEquals(2, BinaryUnivalTree.count);

    BinaryUnivalTree.count = 0;
    root = new BSTNode(2);
    root.left = new BSTNode(2);
    Assert.assertTrue(bu.isUnival(root));
    Assert.assertTrue(bu.getUnivalSubtrees(root));
    Assert.assertEquals(2, BinaryUnivalTree.count);


  }
}
