package test;

import java.util.List;

import main.DirectedGraph;

import org.junit.Assert;
import org.junit.Test;

public class DirectedGraphTest {
  @Test
  public void testCycle() {
    DirectedGraph dg = new DirectedGraph(9);
    dg.addEdge(0, 1);
    dg.addEdge(0, 8);
    dg.addEdge(8, 2);
    dg.addEdge(2, 3);
    dg.addEdge(2, 4);
    dg.addEdge(2, 5);
    dg.addEdge(5, 7);
    dg.addEdge(5, 6);
    dg.addEdge(6, 8);
    Assert.assertTrue(dg.isCyclic());
  }

  @Test
  public void testBFS() {
    DirectedGraph dg = new DirectedGraph(9);
    dg.addEdge(0, 1);
    dg.addEdge(0, 8);
    dg.addEdge(8, 2);
    dg.addEdge(2, 3);
    dg.addEdge(2, 4);
    dg.addEdge(2, 5);
    dg.addEdge(5, 7);
    dg.addEdge(6, 8);
    List<Integer> result = dg.bfs(0);
    Assert.assertEquals(0, result.get(0).intValue());
    Assert.assertEquals(1, result.get(1).intValue());
    Assert.assertEquals(8, result.get(2).intValue());
    Assert.assertEquals(2, result.get(3).intValue());
    Assert.assertEquals(3, result.get(4).intValue());
    Assert.assertEquals(4, result.get(5).intValue());
    Assert.assertEquals(5, result.get(6).intValue());
    Assert.assertEquals(7, result.get(7).intValue());
  }
}
