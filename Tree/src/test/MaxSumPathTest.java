package test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import main.BinarySearchTree.BSTNode;
import main.MaxSumPath;

import org.junit.Test;

public class MaxSumPathTest {

  @Test
  public void test() {
    BSTNode root = new BSTNode(10);
    root.left = new BSTNode(-2);
    root.right = new BSTNode(7);
    root.left.left = new BSTNode(8);
    root.left.right = new BSTNode(-4);
    MaxSumPath msp = new MaxSumPath();
    Assert.assertEquals(17, msp.getMaxSum(root));
    List<Integer> expected = new ArrayList<Integer>();
    expected = msp.getMaxSumPath(root);
    Assert.assertEquals(7, expected.get(0).intValue());
    Assert.assertEquals(10, expected.get(1).intValue());
  }
}
