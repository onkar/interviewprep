package test;

import java.util.List;

import junit.framework.Assert;
import main.BinarySearchTree;
import main.LevelWiseTraversal;

import org.junit.Before;
import org.junit.Test;

public class LevelWiseTraversalTest {
  private LevelWiseTraversal lwt;
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

    lwt = new LevelWiseTraversal(bst.root());
  }

  @Test
  public void test() {
    List<Integer> list = lwt.levelWise();
    Assert.assertEquals(12, list.get(0).intValue());
    Assert.assertEquals(5, list.get(1).intValue());
    Assert.assertEquals(15, list.get(2).intValue());
    Assert.assertEquals(3, list.get(3).intValue());
    Assert.assertEquals(7, list.get(4).intValue());
    Assert.assertEquals(13, list.get(5).intValue());
    Assert.assertEquals(17, list.get(6).intValue());
    Assert.assertEquals(1, list.get(7).intValue());
    Assert.assertEquals(9, list.get(8).intValue());

    bst.delete(15);
    list.clear();
    lwt = new LevelWiseTraversal(bst.root());
    list = lwt.levelWise();
    Assert.assertEquals(12, list.get(0).intValue());
    Assert.assertEquals(5, list.get(1).intValue());
    Assert.assertEquals(17, list.get(2).intValue());
    Assert.assertEquals(3, list.get(3).intValue());
    Assert.assertEquals(7, list.get(4).intValue());
    Assert.assertEquals(13, list.get(5).intValue());
    Assert.assertEquals(1, list.get(6).intValue());
    Assert.assertEquals(9, list.get(7).intValue());
  }

}
