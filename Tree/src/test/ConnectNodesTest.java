package test;

import main.ConnectNodes;
import main.SpecialNode;

import org.junit.Assert;
import org.junit.Test;

public class ConnectNodesTest {
  @Test
  public void test() {
    SpecialNode root = new SpecialNode(1);
    root.left = new SpecialNode(2);
    root.right = new SpecialNode(3);
    root.left.left = new SpecialNode(4);
    root.left.right = new SpecialNode(5);
    root.right.left = new SpecialNode(6);
    root.right.right = new SpecialNode(7);
    ConnectNodes.connect(root);

    Assert.assertEquals(null, root.next);
    Assert.assertEquals(3, root.left.next.data);
    Assert.assertEquals(null, root.right.next);
    Assert.assertEquals(5, root.left.left.next.data);
    Assert.assertEquals(6, root.left.right.next.data);
    Assert.assertEquals(7, root.right.left.next.data);
    Assert.assertEquals(null, root.right.right.next);
  }
}
