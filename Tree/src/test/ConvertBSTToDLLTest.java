package test;

import junit.framework.Assert;
import main.BinarySearchTree;
import main.BinarySearchTree.BSTNode;
import main.ConvertBSTToDLL;

import org.junit.Before;
import org.junit.Test;

public class ConvertBSTToDLLTest {
  private BinarySearchTree bst;
  private ConvertBSTToDLL c;

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

    c = new ConvertBSTToDLL(bst.root());
  }

  @Test
  public void test() {
    BSTNode head = c.treeToList();
    Assert.assertEquals(1, head.data);
    Assert.assertEquals(3, head.right.data);
    Assert.assertEquals(5, head.right.right.data);
    Assert.assertEquals(7, head.right.right.right.data);
    Assert.assertEquals(9, head.right.right.right.right.data);
    Assert.assertEquals(12, head.right.right.right.right.right.data);
    Assert.assertEquals(13, head.right.right.right.right.right.right.data);
    Assert.assertEquals(15, head.right.right.right.right.right.right.right.data);
    Assert.assertEquals(17, head.right.right.right.right.right.right.right.right.data);
  }
}
