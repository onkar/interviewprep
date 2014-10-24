package test;

import junit.framework.Assert;
import main.InorderSuccessor;
import main.InorderSuccessor.BTNode;

import org.junit.Test;

public class InorderSuccessorTest {

  @Test
  public void test() {
    BTNode root = new BTNode(1);
    root.left = new BTNode(2);
    root.right = new BTNode(3);
    root.left.left = new BTNode(4);
    root.left.right = new BTNode(5);
    root.right.left = new BTNode(6);
    InorderSuccessor is = new InorderSuccessor(root);
    root = is.populateNextInorder();
    Assert.assertEquals(root.left, root.left.left.next);
    Assert.assertEquals(root.left.right, root.left.next);
    Assert.assertEquals(root, root.left.right.next);
    Assert.assertEquals(root.right.left, root.next);
    Assert.assertEquals(root.right, root.right.left.next);
    Assert.assertNull(root.right.next);
  }
}
