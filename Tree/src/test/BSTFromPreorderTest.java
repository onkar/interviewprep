package test;

import junit.framework.Assert;
import main.BSTFromPreorder;
import main.BinarySearchTree.BSTNode;

import org.junit.Test;

public class BSTFromPreorderTest {
  private final int[] preorder = {10, 5, 1, 7, 40, 50};
  private BSTFromPreorder bfp;

  @Test
  public void test() {
    bfp = new BSTFromPreorder(preorder);
    BSTNode root = bfp.getBST();
    Assert.assertEquals(10, root.data);
    Assert.assertEquals(5, root.left.data);
    Assert.assertEquals(1, root.left.left.data);
    Assert.assertEquals(7, root.left.right.data);
    Assert.assertEquals(40, root.right.data);
    Assert.assertEquals(50, root.right.right.data);
  }
}
