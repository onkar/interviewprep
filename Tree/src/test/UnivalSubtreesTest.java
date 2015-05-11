package test;

import main.BinarySearchTree.BSTNode;
import main.UnivalSubtrees;

import org.junit.Assert;
import org.junit.Test;

public class UnivalSubtreesTest {
  @Test
  public void test() {
    BSTNode root = new BSTNode(1);
    root.left = new BSTNode(2);
    root.left.left = new BSTNode(2);
    root.left.right = new BSTNode(2);
    root.left.left.left = new BSTNode(5);
    root.left.left.right = new BSTNode(5);
    root.right = new BSTNode(3);
    root.right.left = new BSTNode(3);
    root.right.right = new BSTNode(3);
    root.right.left.left = new BSTNode(4);
    root.right.left.right = new BSTNode(4);
    root.right.right.left = new BSTNode(3);
    root.right.right.right = new BSTNode(3);

    Assert.assertEquals(8, UnivalSubtrees.count(root));
  }
}
