package test;

import java.util.HashMap;
import java.util.Map;

import main.GraphPath;
import main.Node;

import org.junit.Assert;
import org.junit.Test;

public class GraphPathTest {
  @Test
  public void test() {
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
    one.neighbors.add(zero);
    two.neighbors.add(three);
    two.neighbors.add(four);
    two.neighbors.add(five);
    two.neighbors.add(eight);
    three.neighbors.add(two);
    four.neighbors.add(two);
    four.neighbors.add(seven);
    five.neighbors.add(two);
    five.neighbors.add(six);
    six.neighbors.add(five);
    six.neighbors.add(seven);
    six.neighbors.add(eight);
    seven.neighbors.add(four);
    seven.neighbors.add(six);
    eight.neighbors.add(two);
    eight.neighbors.add(six);
    eight.neighbors.add(zero);

    Map<Integer, Node> undirectedGraph = new HashMap<Integer, Node>();
    undirectedGraph.put(0, zero);
    undirectedGraph.put(1, one);
    undirectedGraph.put(2, two);
    undirectedGraph.put(3, three);
    undirectedGraph.put(4, four);
    undirectedGraph.put(5, five);
    undirectedGraph.put(6, six);
    undirectedGraph.put(7, seven);
    undirectedGraph.put(8, eight);

    Assert.assertTrue(GraphPath.search(undirectedGraph, eight, five));

    Node nine = new Node(9);
    Assert.assertFalse(GraphPath.search(undirectedGraph, zero, nine));
  }
}
