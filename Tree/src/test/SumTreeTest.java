package test;

import junit.framework.Assert;
import main.BinarySearchTree;
import main.BinarySearchTree.BSTNode;
import main.SumTree;

import org.junit.Before;
import org.junit.Test;

public class SumTreeTest {
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
    SumTree st = new SumTree(bst.root());
    BSTNode newRoot = st.convertToSumTree();
    Assert.assertEquals(82, newRoot.data);
    Assert.assertEquals(25, newRoot.left.data);
    Assert.assertEquals(45, newRoot.right.data);
    Assert.assertEquals(4, newRoot.left.left.data);
    Assert.assertEquals(16, newRoot.left.right.data);
    Assert.assertEquals(13, newRoot.right.left.data);
    Assert.assertEquals(17, newRoot.right.right.data);
    Assert.assertEquals(1, newRoot.left.left.left.data);
    Assert.assertEquals(9, newRoot.left.right.right.data);
  }
}
