package test;

import main.BinarySearchTree.BSTNode;
import main.SecondLargest;

import org.junit.Assert;
import org.junit.Test;

public class SecondLargestTest {
  @Test
  public void test() {
    BSTNode root1 = new BSTNode(5);
    root1.left = new BSTNode(3);
    root1.right = new BSTNode(8);
    root1.left.left = new BSTNode(1);
    root1.left.right = new BSTNode(4);
    root1.right.left = new BSTNode(7);
    root1.right.right = new BSTNode(12);
    root1.right.right.left = new BSTNode(10);
    root1.right.right.left.left = new BSTNode(9);
    root1.right.right.left.right = new BSTNode(11);
    Assert.assertEquals(11, SecondLargest.get(root1));

    BSTNode root2 = new BSTNode(5);
    root2.left = new BSTNode(3);
    Assert.assertEquals(3, SecondLargest.get(root2));

    BSTNode root3 = new BSTNode(5);
    Assert.assertEquals(Integer.MIN_VALUE, SecondLargest.get(root3));
  }
}
