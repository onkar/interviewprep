package test;


import main.BinarySearchTree.BSTNode;
import main.LowestCommonAncestor;

import org.junit.Assert;
import org.junit.Test;

public class LowestCommonAncestorTest {
  @Test
  public void test() {
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
    Assert.assertEquals(5, lca.findLCA(root, root.left.left, root.left.right).data);
  }
}
