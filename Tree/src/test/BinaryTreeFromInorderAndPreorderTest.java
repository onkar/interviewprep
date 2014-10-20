package test;

import junit.framework.Assert;
import main.BinarySearchTree.BSTNode;
import main.BinaryTreeFromInorderAndPreorder;

import org.junit.Test;

public class BinaryTreeFromInorderAndPreorderTest {
  private BinaryTreeFromInorderAndPreorder bt;

  @Test
  public void test() {
    int[] preorder = {7, 10, 4, 3, 1, 2, 8, 11};
    int[] inorder = {4, 10, 3, 1, 7, 11, 8, 2};
    bt = new BinaryTreeFromInorderAndPreorder(inorder, preorder);
    BSTNode root = bt.constructBinaryTree();
    Assert.assertEquals(7, root.data);
    Assert.assertEquals(10, root.left.data);
    Assert.assertEquals(2, root.right.data);
    Assert.assertEquals(4, root.left.left.data);
    Assert.assertEquals(3, root.left.right.data);
    Assert.assertEquals(8, root.right.left.data);
    Assert.assertEquals(1, root.left.right.right.data);
    Assert.assertEquals(11, root.right.left.left.data);
  }
}
