package test;

import java.util.HashMap;

import junit.framework.Assert;
import main.BinarySearchTree.BSTNode;
import main.VerticleSum;

import org.junit.Test;

public class VerticleSumTest {

  @Test
  public void test() {
    BSTNode root = new BSTNode(1);
    root.left = new BSTNode(2);
    root.right = new BSTNode(3);
    root.left.left = new BSTNode(4);
    root.left.right = new BSTNode(5);
    root.right.left = new BSTNode(6);
    root.right.right = new BSTNode(7);
    VerticleSum vs = new VerticleSum();
    HashMap<Integer, Integer> hm = vs.getVerticleSum(root);
    Assert.assertEquals(4, hm.get(-2).intValue());
    Assert.assertEquals(2, hm.get(-1).intValue());
    Assert.assertEquals(12, hm.get(0).intValue());
    Assert.assertEquals(3, hm.get(1).intValue());
    Assert.assertEquals(7, hm.get(2).intValue());
  }
}
