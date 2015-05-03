package test;

import java.util.ArrayList;
import java.util.List;

import main.MergeKSortedLists;

import org.junit.Assert;
import org.junit.Test;

public class MergeSortedListsTest {
  @Test
  public void test() {
    @SuppressWarnings("serial")
    ArrayList<Integer> l1 = new ArrayList<Integer>() {
      {
        add(8);
        add(15);
        add(17);
        add(20);
      }
    };

    @SuppressWarnings("serial")
    ArrayList<Integer> l2 = new ArrayList<Integer>() {
      {
        add(1);
        add(7);
        add(11);
        add(13);
      }
    };

    @SuppressWarnings("serial")
    ArrayList<Integer> l3 = new ArrayList<Integer>() {
      {
        add(5);
        add(9);
        add(11);
        add(18);
      }
    };


    List<ArrayList<Integer>> l = new ArrayList<ArrayList<Integer>>();
    l.add(l1);
    l.add(l2);
    l.add(l3);

    MergeKSortedLists msl = new MergeKSortedLists();
    List<Integer> merged = msl.merge(l);
    Assert.assertEquals(1, merged.get(0).intValue());
    Assert.assertEquals(5, merged.get(1).intValue());
    Assert.assertEquals(7, merged.get(2).intValue());
    Assert.assertEquals(8, merged.get(3).intValue());
    Assert.assertEquals(9, merged.get(4).intValue());
    Assert.assertEquals(11, merged.get(5).intValue());
    Assert.assertEquals(11, merged.get(6).intValue());
    Assert.assertEquals(13, merged.get(7).intValue());
    Assert.assertEquals(15, merged.get(8).intValue());
    Assert.assertEquals(17, merged.get(9).intValue());
    Assert.assertEquals(18, merged.get(10).intValue());
    Assert.assertEquals(20, merged.get(11).intValue());
  }
}
