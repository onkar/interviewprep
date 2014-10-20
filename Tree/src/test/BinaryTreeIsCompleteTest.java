package test;

import main.BinarySearchTree;
import main.BinaryTreeIsComplete;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinaryTreeIsCompleteTest {
  private BinarySearchTree bst;

  @Before
  public void setup() {
    bst = new BinarySearchTree();
    bst.insert(12);
    bst.insert(5);
    bst.insert(15);
    bst.insert(3);
    bst.insert(7);
    bst.insert(13);
    bst.insert(17);
    bst.insert(1);
    bst.insert(9);
  }

  @Test
  public void test() {
    BinaryTreeIsComplete c = new BinaryTreeIsComplete();
    Assert.assertFalse(c.isBinaryTreeComplete(bst.root()));
    bst.delete(1);
    bst.delete(9);
    Assert.assertTrue(c.isBinaryTreeComplete(bst.root()));
  }
}
