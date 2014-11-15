package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class DirectedGraph {
  private final Map<Integer, Set<Integer>> adjacencyList;

  public DirectedGraph(int vertices) {
    adjacencyList = new HashMap<Integer, Set<Integer>>();
    for (int i = 0; i < vertices; i++) {
      adjacencyList.put(i, new HashSet<Integer>());
    }
  }

  public void addEdge(int source, int destination) {
    if (adjacencyList.containsKey(source) && adjacencyList.containsKey(destination)) {
      // Update source node's adjacency list with destination
      Set<Integer> adjacentNodes = adjacencyList.get(source);
      adjacentNodes.add(destination);
      adjacencyList.put(source, adjacentNodes);
    }
  }

  public void addEdges(int source, Set<Integer> nodes) {
    for (int i : nodes) {
      addEdge(source, i);
    }
  }

  public Set<Integer> getAdjacentNodes(int source) {
    return adjacencyList.get(source);
  }

  public List<Integer> bfs(int start) {
    Queue<Integer> queue = new LinkedList<Integer>();
    queue.add(start);
    boolean[] visited = new boolean[adjacencyList.size()];
    visited[start] = true;
    List<Integer> result = new ArrayList<Integer>();
    while (!queue.isEmpty()) {
      int node = queue.remove();
      result.add(node);
      for (int adjNode : getAdjacentNodes(node)) {
        if (!visited[adjNode]) {
          visited[adjNode] = true;
          queue.add(adjNode);
        }
      }
    }
    return result;
  }

  public List<Integer> dfs(int start) {
    Stack<Integer> stack = new Stack<Integer>();
    List<Integer> result = new ArrayList<Integer>();
    boolean[] visited = new boolean[adjacencyList.size()];

    stack.push(start);
    visited[start] = true;
    result.add(start);

    while (!stack.isEmpty()) {
      int node = stack.peek();
      Set<Integer> adjacentNodes = getAdjacentNodes(node);
      Iterator<Integer> itr = adjacentNodes.iterator();
      if (itr.hasNext()) {
        int adjNode = itr.next();
        itr.remove();
        if (!visited[adjNode]) {
          stack.push(adjNode);
          result.add(adjNode);
          visited[adjNode] = true;
        } else {
          stack.pop();
        }
      }
    }
    return result;
  }

  public boolean isCyclic() {
    Stack<Integer> stack = new Stack<Integer>();
    boolean[] visited = new boolean[adjacencyList.size()];
    int start = 0;
    stack.push(start);
    visited[start] = true;
    boolean cyclic = false;
    while (!stack.isEmpty()) {
      int node = stack.peek();
      Set<Integer> adjacentNodes = getAdjacentNodes(node);
      Iterator<Integer> it = adjacentNodes.iterator();
      if (it.hasNext()) {
        // There are adjacent nodes present
        int adjNode = it.next();
        it.remove();
        if (!visited[adjNode]) {
          visited[adjNode] = true;
          stack.push(adjNode);
        } else {
          // If we are visiting already visited nodes, then there is a cycle
          cyclic = true;
          break;
        }
      } else {
        // Pop the stack if there are no adjacent nodes
        stack.pop();
      }
    }
    return cyclic;
  }

  public int size() {
    return adjacencyList.size();
  }
}
