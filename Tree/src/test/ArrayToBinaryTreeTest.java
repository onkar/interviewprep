package test;

import main.ArrayToBinaryTree;
import main.BinarySearchTree.BSTNode;

import org.junit.Assert;
import org.junit.Test;

public class ArrayToBinaryTreeTest {

  @Test
  public void test() {
    int[] array = {7, 3, 9, 2, 4, 8, 10};
    BSTNode root = ArrayToBinaryTree.convert(array);
    Assert.assertEquals(7, root.data);
    Assert.assertEquals(3, root.left.data);
    Assert.assertEquals(9, root.right.data);
    Assert.assertEquals(2, root.left.left.data);
    Assert.assertEquals(4, root.left.right.data);
    Assert.assertEquals(8, root.right.left.data);
    Assert.assertEquals(10, root.right.right.data);

    Assert.assertNull(root.left.left.left);
    Assert.assertNull(root.left.left.right);
    Assert.assertNull(root.left.right.left);
    Assert.assertNull(root.left.right.right);
    Assert.assertNull(root.right.left.left);
    Assert.assertNull(root.right.left.right);
    Assert.assertNull(root.right.right.left);
    Assert.assertNull(root.right.right.right);
  }
}
