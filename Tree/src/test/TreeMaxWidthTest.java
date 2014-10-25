package test;

import junit.framework.Assert;
import main.BinarySearchTree.BSTNode;
import main.TreeMaxWidth;

import org.junit.Test;

public class TreeMaxWidthTest {

  @Test
  public void test() {
    BSTNode root = new BSTNode(1);
    root.left = new BSTNode(2);
    root.right = new BSTNode(3);
    root.left.left = new BSTNode(4);
    root.left.right = new BSTNode(5);
    root.right.right = new BSTNode(8);
    root.right.right.left = new BSTNode(6);
    root.right.right.right = new BSTNode(7);
    TreeMaxWidth tmw = new TreeMaxWidth();
    Assert.assertEquals(3, tmw.getMaxWidth(root));
  }
}
