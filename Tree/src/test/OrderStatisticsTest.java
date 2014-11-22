package test;

import junit.framework.Assert;
import main.BinarySearchTree;
import main.BinarySearchTree.BSTNode;
import main.OrderStatistics;

import org.junit.Test;

public class OrderStatisticsTest {
  @Test
  public void testKthSmallest() {
    OrderStatistics os = new OrderStatistics();
    BinarySearchTree bst = new BinarySearchTree();
    bst.insert(45);
    bst.insert(40);
    bst.insert(55);
    bst.insert(37);
    bst.insert(44);
    bst.insert(93);
    bst.insert(11);
    bst.insert(39);
    bst.insert(43);
    BSTNode result = os.kthSmallest(bst.root(), 4);
    Assert.assertEquals(40, result.data);
    result = os.kthSmallest(bst.root(), 5);
    Assert.assertEquals(43, result.data);
    result = os.kthSmallest(bst.root(), 1);
    Assert.assertEquals(11, result.data);
  }

  @Test
  public void testKthLargest() {
    OrderStatistics os = new OrderStatistics();
    BinarySearchTree bst = new BinarySearchTree();
    bst.insert(45);
    bst.insert(40);
    bst.insert(55);
    bst.insert(37);
    bst.insert(44);
    bst.insert(93);
    bst.insert(11);
    bst.insert(39);
    bst.insert(43);
    BSTNode result = os.kthLargest(bst.root(), 4);
    Assert.assertEquals(44, result.data);
    result = os.kthLargest(bst.root(), 5);
    Assert.assertEquals(43, result.data);
    result = os.kthLargest(bst.root(), 1);
    Assert.assertEquals(93, result.data);
  }
}
