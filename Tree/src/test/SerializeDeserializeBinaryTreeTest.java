package test;

import junit.framework.Assert;
import main.BinarySearchTree.BSTNode;
import main.SerializeDeserializeBinaryTree;

import org.junit.Test;

public class SerializeDeserializeBinaryTreeTest {
  @Test
  public void test() {
    BSTNode root = new BSTNode(30);
    root.left = new BSTNode(10);
    root.right = new BSTNode(20);
    root.left.left = new BSTNode(50);
    root.right.left = new BSTNode(45);
    root.right.right = new BSTNode(35);
    SerializeDeserializeBinaryTree s = new SerializeDeserializeBinaryTree();
    String serialized = s.serialize(root);
    BSTNode result = s.deserialize(serialized);
    Assert.assertEquals(30, result.data);
    Assert.assertEquals(10, result.left.data);
    Assert.assertEquals(20, result.right.data);
    Assert.assertEquals(50, result.left.left.data);
    Assert.assertEquals(45, result.right.left.data);
    Assert.assertEquals(35, result.right.right.data);
  }
}
