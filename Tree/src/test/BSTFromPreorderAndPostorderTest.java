package test;

import junit.framework.Assert;
import main.BinarySearchTree.BSTNode;
import main.BinaryTreeFromPreorderAndPostorder;

import org.junit.Test;

public class BSTFromPreorderAndPostorderTest {
  private BinaryTreeFromPreorderAndPostorder pp;

  @Test
  public void test() {
    int[] preorder = {1, 2, 4, 8, 9, 5, 3, 6, 7};
    int[] postorder = {8, 9, 4, 5, 2, 6, 7, 3, 1};
    pp = new BinaryTreeFromPreorderAndPostorder(preorder, postorder);
    BSTNode root = pp.constructBinaryTree();

    Assert.assertEquals(1, root.data);
    Assert.assertEquals(2, root.left.data);
    Assert.assertEquals(3, root.right.data);
    Assert.assertEquals(4, root.left.left.data);
    Assert.assertEquals(5, root.left.right.data);
    Assert.assertEquals(6, root.right.left.data);
    Assert.assertEquals(7, root.right.right.data);
    Assert.assertEquals(8, root.left.left.left.data);
    Assert.assertEquals(9, root.left.left.right.data);
  }
}
