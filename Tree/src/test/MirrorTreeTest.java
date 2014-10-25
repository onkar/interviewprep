package test;

import junit.framework.Assert;
import main.BinarySearchTree.BSTNode;
import main.MirrorTree;

import org.junit.Test;

public class MirrorTreeTest {
  @Test
  public void test() {
    BSTNode root = new BSTNode(1);
    root.left = new BSTNode(3);
    root.right = new BSTNode(2);
    root.right.left = new BSTNode(5);
    root.right.right = new BSTNode(4);
    MirrorTree mt = new MirrorTree();
    mt.doMirror(root);
    Assert.assertEquals(2, root.left.data);
    Assert.assertEquals(3, root.right.data);
    Assert.assertEquals(4, root.left.left.data);
    Assert.assertEquals(5, root.left.right.data);
  }
}
