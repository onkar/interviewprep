package test;

import main.AllSumPaths;
import main.BinarySearchTree.BSTNode;

import org.junit.Test;

public class AllSumPathsTest {
  @Test
  public void test() {
    BSTNode root = new BSTNode(10);
    root.left = new BSTNode(-2);
    root.right = new BSTNode(7);
    root.left.left = new BSTNode(8);
    root.left.right = new BSTNode(-4);
    AllSumPaths asp = new AllSumPaths();
    asp.printAllSumPath(root, 4);
    asp.printAllSumPath(root, 6);
  }
}
