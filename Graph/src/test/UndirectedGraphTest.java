package test;

import java.util.List;

import main.UndirectedGraph;

import org.junit.Assert;
import org.junit.Test;

public class UndirectedGraphTest {
  @Test
  public void testBFS() {
    UndirectedGraph g = new UndirectedGraph(9);
    g.addEdge(0, 1);
    g.addEdge(0, 8);
    g.addEdge(8, 2);
    g.addEdge(8, 6);
    g.addEdge(2, 3);
    g.addEdge(2, 4);
    g.addEdge(2, 5);
    g.addEdge(6, 5);
    g.addEdge(6, 7);
    g.addEdge(7, 4);

    List<Integer> result = g.bfs(0);
    Assert.assertEquals(0, result.get(0).intValue());
    Assert.assertEquals(1, result.get(1).intValue());
    Assert.assertEquals(8, result.get(2).intValue());
    Assert.assertEquals(2, result.get(3).intValue());
    Assert.assertEquals(6, result.get(4).intValue());
    Assert.assertEquals(3, result.get(5).intValue());
    Assert.assertEquals(4, result.get(6).intValue());
    Assert.assertEquals(5, result.get(7).intValue());
    Assert.assertEquals(7, result.get(8).intValue());
  }

  @Test
  public void testDFS() {
    UndirectedGraph g = new UndirectedGraph(9);
    g.addEdge(0, 1);
    g.addEdge(0, 8);
    g.addEdge(8, 2);
    g.addEdge(8, 6);
    g.addEdge(2, 3);
    g.addEdge(2, 4);
    g.addEdge(2, 5);
    g.addEdge(6, 5);
    g.addEdge(6, 7);
    g.addEdge(7, 4);
    List<Integer> result = g.dfs(0);
    Assert.assertEquals(0, result.get(0).intValue());
    Assert.assertEquals(1, result.get(1).intValue());
    Assert.assertEquals(8, result.get(2).intValue());
    Assert.assertEquals(2, result.get(3).intValue());
    Assert.assertEquals(3, result.get(4).intValue());
    Assert.assertEquals(4, result.get(5).intValue());
    Assert.assertEquals(7, result.get(6).intValue());
    Assert.assertEquals(6, result.get(7).intValue());
    Assert.assertEquals(5, result.get(8).intValue());
  }
}
