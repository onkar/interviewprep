package test;

import junit.framework.Assert;
import main.BinarySearchTree;
import main.RemoveKeysOutsideRange;

import org.junit.Test;

public class RemoveKeysOutsideRangeTest {
  @Test
  public void test() {
    BinarySearchTree bst = new BinarySearchTree();
    bst.insert(6);
    bst.insert(-13);
    bst.insert(14);
    bst.insert(-8);
    bst.insert(13);
    bst.insert(15);
    bst.insert(7);

    RemoveKeysOutsideRange rr = new RemoveKeysOutsideRange();
    rr.remove(bst.root(), -10, 13);
    Assert.assertEquals(6, bst.root().data);
    Assert.assertEquals(-8, bst.root().left.data);
    Assert.assertEquals(13, bst.root().right.data);
    Assert.assertEquals(7, bst.root().right.left.data);
  }
}
