package test;

import junit.framework.Assert;
import main.BinarySearchTree;
import main.BinarySearchTree.BSTNode;
import main.FindInorderSuccessor;

import org.junit.Before;
import org.junit.Test;

public class FindInorderSuccessorTest {
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
  public void testFindInorder() {
    FindInorderSuccessor sis = new FindInorderSuccessor();
    BSTNode node = sis.getInorderSuccessor(bst.root(), bst.root().right);
    Assert.assertEquals(17, node.data);
    node = sis.getInorderSuccessor(bst.root(), bst.root().left.left);
    Assert.assertEquals(5, node.data);
    node = sis.getInorderSuccessor(bst.root(), bst.root().right.right);
    Assert.assertNull(node);
  }
}
