package main;

import java.util.ArrayList;
import java.util.List;
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
  private final Stack<Integer> stack;

  public TopologicalSort(DirectedGraph g) {
    visited = new boolean[g.size()];
    stack = new Stack<Integer>();
  }

  public List<Integer> sort(DirectedGraph dg) {
    for (int v = 0; v < dg.size(); v++) {
      // Go through all the nodes and call dfs if they are not visited
      if (!visited[v])
        dfs(dg, v);
    }
    // After dfs, the stack should contain the reverse ordered dependency sequence of nodes (least
    // dependent node on top and max dependent at the bottom). So convert it to a list and return it
    List<Integer> result = new ArrayList<Integer>();
    while (!stack.isEmpty()) {
      result.add(stack.pop());
    }
    return result;
  }

  private void dfs(DirectedGraph dg, int v) {
    // Set visited of the current node to true, call dfs for all adjacent nodes of the current node
    // and push the current node to stack
    visited[v] = true;
    for (int adjNode : dg.getAdjacentNodes(v)) {
      if (!visited[adjNode])
        dfs(dg, adjNode);
    }
    stack.push(v);
  }
}
