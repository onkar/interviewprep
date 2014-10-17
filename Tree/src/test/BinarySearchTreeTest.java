package test;

import java.util.List;

import junit.framework.Assert;
import main.BinarySearchTree;

import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeTest {
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
  public void testInorder() {
    List<Integer> inorder = bst.inorder();
    // [1, 3, 5, 7, 9, 12, 13, 15, 17]
    Assert.assertEquals(1, inorder.get(0).intValue());
    Assert.assertEquals(3, inorder.get(1).intValue());
    Assert.assertEquals(5, inorder.get(2).intValue());
    Assert.assertEquals(7, inorder.get(3).intValue());
    Assert.assertEquals(9, inorder.get(4).intValue());
    Assert.assertEquals(12, inorder.get(5).intValue());
    Assert.assertEquals(13, inorder.get(6).intValue());
    Assert.assertEquals(15, inorder.get(7).intValue());
    Assert.assertEquals(17, inorder.get(8).intValue());
  }

  @Test
  public void testDelete() {
    // Delete leaf node
    bst.delete(9);
    List<Integer> inorder = bst.inorder();
    // [1, 3, 5, 7, 12, 13, 15, 17]
    Assert.assertEquals(1, inorder.get(0).intValue());
    Assert.assertEquals(3, inorder.get(1).intValue());
    Assert.assertEquals(5, inorder.get(2).intValue());
    Assert.assertEquals(7, inorder.get(3).intValue());
    Assert.assertEquals(12, inorder.get(4).intValue());
    Assert.assertEquals(13, inorder.get(5).intValue());
    Assert.assertEquals(15, inorder.get(6).intValue());
    Assert.assertEquals(17, inorder.get(7).intValue());

    inorder.clear();

    // Delete node with one child
    bst.delete(3);
    inorder = bst.inorder();
    // [1, 5, 7, 12, 13, 15, 17]
    Assert.assertEquals(1, inorder.get(0).intValue());
    Assert.assertEquals(5, inorder.get(1).intValue());
    Assert.assertEquals(7, inorder.get(2).intValue());
    Assert.assertEquals(12, inorder.get(3).intValue());
    Assert.assertEquals(13, inorder.get(4).intValue());
    Assert.assertEquals(15, inorder.get(5).intValue());
    Assert.assertEquals(17, inorder.get(6).intValue());

    inorder.clear();

    // Delete node with 2 children
    bst.delete(15);
    inorder = bst.inorder();
    // [1, 5, 7, 12, 13, 17]
    Assert.assertEquals(1, inorder.get(0).intValue());
    Assert.assertEquals(5, inorder.get(1).intValue());
    Assert.assertEquals(7, inorder.get(2).intValue());
    Assert.assertEquals(12, inorder.get(3).intValue());
    Assert.assertEquals(13, inorder.get(4).intValue());
    Assert.assertEquals(17, inorder.get(5).intValue());
  }

  @Test
  public void testHeight() {
    Assert.assertEquals(4, bst.getHeight());
  }
}
