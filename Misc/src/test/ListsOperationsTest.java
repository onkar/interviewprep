package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import main.ListsOperations;

import org.junit.Assert;
import org.junit.Test;

public class ListsOperationsTest {
  @Test
  public void test() {
    List<List<Integer>> l = new ArrayList<List<Integer>>();
    List<Integer> inner1 = Arrays.asList(5, 3, 6, 2);
    List<Integer> inner2 = Arrays.asList(9, 11, 3, 5);
    List<Integer> inner3 = Arrays.asList(3, 10, 12, 5);
    l.add(inner1);
    l.add(inner2);
    l.add(inner3);

    List<Integer> intersection = ListsOperations.intersection(l);
    Assert.assertEquals(3, intersection.get(0).intValue());
    Assert.assertEquals(5, intersection.get(1).intValue());

    List<Integer> union = ListsOperations.union(l);
    Assert.assertEquals(2, union.get(0).intValue());
    Assert.assertEquals(3, union.get(1).intValue());
    Assert.assertEquals(5, union.get(2).intValue());
    Assert.assertEquals(6, union.get(3).intValue());
    Assert.assertEquals(9, union.get(4).intValue());
    Assert.assertEquals(10, union.get(5).intValue());
    Assert.assertEquals(11, union.get(6).intValue());
    Assert.assertEquals(12, union.get(7).intValue());

  }
}
