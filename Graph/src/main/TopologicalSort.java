package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

/**
 * Topological sort only works on acyclic digraphs.
 * 
 * <pre>
 * Details - https://www.youtube.com/watch?v=jksMzq4LgfM
 * </pre>
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 *
 */
public class TopologicalSort {
  private final boolean[] visited;
  private final Stack<Node> stack;

  public TopologicalSort(Map<Integer, Node> directedGraph) {
    visited = new boolean[directedGraph.size()];
    stack = new Stack<Node>();
  }

  public List<Node> sort(Map<Integer, Node> directedGraph) {
    for (Entry<Integer, Node> entry : directedGraph.entrySet()) {
      if (!visited[entry.getValue().label]) {
        dfs(entry.getValue());
      }
    }

    // After dfs, the stack should contain the reverse ordered dependency sequence of nodes (least
    // dependent node on top and max dependent at the bottom). So convert it to a list and return it
    List<Node> result = new ArrayList<Node>();
    while (!stack.isEmpty()) {
      result.add(stack.pop());
    }
    return result;
  }

  private void dfs(Node node) {
    // Set visited of the current node to true, call dfs for all adjacent nodes of the current node
    // and push the current node to stack
    visited[node.label] = true;
    for (Node adjNode : node.neighbors) {
      if (!visited[adjNode.label])
        dfs(adjNode);
    }
    stack.push(node);
  }
}
