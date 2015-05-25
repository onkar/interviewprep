package test;

import main.BinarySearchTree.BSTNode;
import main.VerticlePrint;

import org.junit.Test;

public class VerticlePrintTest {
  @Test
  public void test() {
    BSTNode root = new BSTNode(1);
    root.left = new BSTNode(2);
    root.right = new BSTNode(3);
    root.left.left = new BSTNode(4);
    root.left.right = new BSTNode(5);
    root.left.left.left = new BSTNode(8);
    root.left.left.right = new BSTNode(9);
    root.right.left = new BSTNode(6);
    root.right.right = new BSTNode(7);

    VerticlePrint.print(root);
  }
}
