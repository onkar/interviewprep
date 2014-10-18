package test;

import junit.framework.Assert;
import main.BinarySearchTree;
import main.CeilInBST;

import org.junit.Before;
import org.junit.Test;

public class CeilInBSTTest {
  private BinarySearchTree bst;
  private CeilInBST ceil;

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
    ceil = new CeilInBST();
  }

  @Test
  public void testCeil() {
    Assert.assertEquals(5, ceil.getCeil(bst.root(), 4));
    Assert.assertEquals(17, ceil.getCeil(bst.root(), 16));
    Assert.assertEquals(-1, ceil.getCeil(bst.root(), 18));
  }
}
