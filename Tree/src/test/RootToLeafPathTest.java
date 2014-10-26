package test;

import junit.framework.Assert;
import main.BinarySearchTree.BSTNode;
import main.RootToLeafPath;

import org.junit.Test;

public class RootToLeafPathTest {
  @Test
  public void test() {
    BSTNode root = new BSTNode(5);
    root.left = new BSTNode(2);
    root.right = new BSTNode(1);
    root.left.left = new BSTNode(3);
    RootToLeafPath rtlp = new RootToLeafPath();
    Assert.assertFalse(rtlp.hasPath(root, 7));
    Assert.assertTrue(rtlp.hasPath(root, 10));
  }
}
