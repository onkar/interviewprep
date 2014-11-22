package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import main.DirectedGraphOperations;
import main.Node;

import org.junit.Assert;
import org.junit.Test;

public class DirectedGraphTest {
  @Test
  public void testCycle() {
    Node zero = new Node(0);
    Node one = new Node(1);
    Node two = new Node(2);
    Node three = new Node(3);
    Node four = new Node(4);
    Node five = new Node(5);
    Node six = new Node(6);
    Node seven = new Node(7);
    Node eight = new Node(8);

    zero.neighbors.add(one);
    zero.neighbors.add(eight);
    two.neighbors.add(three);
    two.neighbors.add(four);
    two.neighbors.add(five);
    five.neighbors.add(six);
    five.neighbors.add(seven);
    six.neighbors.add(eight);
    eight.neighbors.add(two);

    Map<Integer, Node> directedGraph = new HashMap<Integer, Node>();
    directedGraph.put(0, zero);
    directedGraph.put(1, one);
    directedGraph.put(2, two);
    directedGraph.put(3, three);
    directedGraph.put(4, four);
    directedGraph.put(5, five);
    directedGraph.put(6, six);
    directedGraph.put(7, seven);
    directedGraph.put(8, eight);

    Assert.assertTrue(DirectedGraphOperations.isCyclic(directedGraph, zero));
  }

  @Test
  public void testBFS() {
    Node zero = new Node(0);
    Node one = new Node(1);
    Node two = new Node(2);
    Node three = new Node(3);
    Node four = new Node(4);
    Node five = new Node(5);
    Node six = new Node(6);
    Node seven = new Node(7);

    zero.neighbors.add(one);
    zero.neighbors.add(seven);
    two.neighbors.add(three);
    two.neighbors.add(four);
    two.neighbors.add(five);
    five.neighbors.add(six);
    seven.neighbors.add(two);

    Map<Integer, Node> directedGraph = new HashMap<Integer, Node>();
    directedGraph.put(0, zero);
    directedGraph.put(1, one);
    directedGraph.put(2, two);
    directedGraph.put(3, three);
    directedGraph.put(4, four);
    directedGraph.put(5, five);
    directedGraph.put(6, six);
    directedGraph.put(7, seven);

    System.out.println("Graph is :");
    printGraph(directedGraph);

    System.out.println("BFS is :");
    for (Node n : DirectedGraphOperations.bfs(directedGraph, zero)) {
      System.out.print(n.label + " ");
    }
    System.out.println();
  }

  private void printGraph(Map<Integer, Node> directedGraph) {
    for (Entry<Integer, Node> e : directedGraph.entrySet()) {
      int key = e.getKey();
      Node value = e.getValue();
      System.out.print(key + "=> ");
      for (Node u : value.neighbors) {
        System.out.print(u.label + " ");
      }
      System.out.println();
    }
  }

  @Test
  public void testDFS() {
    Node zero = new Node(0);
    Node one = new Node(1);
    Node two = new Node(2);
    Node three = new Node(3);
    Node four = new Node(4);
    Node five = new Node(5);
    Node six = new Node(6);
    Node seven = new Node(7);

    zero.neighbors.add(one);
    zero.neighbors.add(seven);
    two.neighbors.add(three);
    two.neighbors.add(four);
    two.neighbors.add(five);
    five.neighbors.add(six);
    seven.neighbors.add(two);

    Map<Integer, Node> directedGraph = new HashMap<Integer, Node>();
    directedGraph.put(0, zero);
    directedGraph.put(1, one);
    directedGraph.put(2, two);
    directedGraph.put(3, three);
    directedGraph.put(4, four);
    directedGraph.put(5, five);
    directedGraph.put(6, six);
    directedGraph.put(7, seven);

    System.out.println("Graph is :");
    printGraph(directedGraph);

    System.out.println("DFS is :");
    for (Node n : DirectedGraphOperations.dfs(directedGraph, zero)) {
      System.out.print(n.label + " ");
    }
    System.out.println();

  }
}
