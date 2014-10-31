package test;

import main.BinarySearchTree;
import main.ClosestNodeInBST;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClosestNodeInBSTTest {
  private BinarySearchTree bst;

  @Before
  public void setup() {
    bst = new BinarySearchTree();
    bst.insert(32);
    bst.insert(24);
    bst.insert(41);
    bst.insert(21);
    bst.insert(28);
    bst.insert(36);
    bst.insert(47);
    bst.insert(14);
    bst.insert(25);
    bst.insert(31);
    bst.insert(39);
  }

  @Test
  public void test() {
    ClosestNodeInBST cnib = new ClosestNodeInBST();
    Assert.assertEquals(28, cnib.getClosestNode(bst.root(), 29).data);
  }
}
