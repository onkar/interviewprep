package test;

import main.AllPaths;
import main.BinarySearchTree.BSTNode;

import org.junit.Test;

public class AllPathsTest {
  @Test
  public void test() {
    BSTNode root = new BSTNode(10);
    root.left = new BSTNode(-2);
    root.right = new BSTNode(7);
    root.left.left = new BSTNode(8);
    root.left.right = new BSTNode(-4);
    AllPaths.print(root);
  }
}
