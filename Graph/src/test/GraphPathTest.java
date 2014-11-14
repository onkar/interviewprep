package test;

import main.UndirectedGraph;
import main.GraphPath;

import org.junit.Assert;
import org.junit.Test;

public class GraphPathTest {
  @Test
  public void test() {
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

    GraphPath gp = new GraphPath();
    Assert.assertTrue(gp.search(g, 8, 5));
    Assert.assertFalse(gp.search(g, 0, 9));
  }
}
