package test;

import java.util.List;

import main.DirectedGraph;
import main.TopologicalSort;

import org.junit.Assert;
import org.junit.Test;

public class TopologicalSortTest {
  @Test
  public void test() {
    DirectedGraph dg = new DirectedGraph(7);
    dg.addEdge(0, 1);
    dg.addEdge(0, 2);
    dg.addEdge(0, 5);
    dg.addEdge(1, 4);
    dg.addEdge(3, 2);
    dg.addEdge(3, 4);
    dg.addEdge(3, 5);
    dg.addEdge(3, 6);
    dg.addEdge(5, 2);
    dg.addEdge(6, 0);
    dg.addEdge(6, 4);

    TopologicalSort ts = new TopologicalSort(dg);
    List<Integer> result = ts.sort(dg);
    Assert.assertEquals(3, result.get(0).intValue());
    Assert.assertEquals(6, result.get(1).intValue());
    Assert.assertEquals(0, result.get(2).intValue());
    Assert.assertEquals(5, result.get(3).intValue());
    Assert.assertEquals(2, result.get(4).intValue());
    Assert.assertEquals(1, result.get(5).intValue());
    Assert.assertEquals(4, result.get(6).intValue());
  }
}
