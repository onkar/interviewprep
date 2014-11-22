package main;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Given a graph, design an algorithm to find out whether there is a route between two nodes.
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 *
 */
public class GraphPath {

  public static boolean search(Map<Integer, Node> undirectedGraph, Node start, Node end) {
    Queue<Node> queue = new LinkedList<Node>();
    queue.add(start);
    boolean[] visited = new boolean[undirectedGraph.size()];
    visited[start.label] = true;
    while (!queue.isEmpty()) {
      Node node = queue.remove();
      for (Node adjNode : node.neighbors) {
        if (!visited[adjNode.label]) {
          if (adjNode == end) {
            return true;
          } else {
            visited[adjNode.label] = true;
            queue.add(adjNode);
          }
        }
      }
    }
    return false;
  }
}
