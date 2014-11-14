package main;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a graph, design an algorithm to find out whether there is a route between two nodes.
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 *
 */
public class GraphPath {

  public boolean search(UndirectedGraph g, int start, int end) {
    Queue<Integer> queue = new LinkedList<Integer>();
    queue.add(start);
    boolean[] visited = new boolean[g.size()];
    visited[start] = true;
    while (!queue.isEmpty()) {
      int node = queue.remove();
      for (int adjNode : g.getAdjacentNodes(node)) {
        if (!visited[adjNode]) {
          if (adjNode == end) {
            return true;
          } else {
            visited[adjNode] = true;
            queue.add(adjNode);
          }
        }
      }
    }
    return false;
  }
}
