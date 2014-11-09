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

public class Graph {
  private final Map<Integer, Set<Integer>> adjacencyList;

  public Graph(int vertices) {
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

      // Update destination node's adjacency list with source
      Set<Integer> revAdjacentNodes = adjacencyList.get(destination);
      revAdjacentNodes.add(source);
      adjacencyList.put(destination, revAdjacentNodes);
    }
  }

  public void addEdges(int source, Set<Integer> nodes) {
    if (adjacencyList.containsKey(source)) {
      for (int i : nodes) {
        if (!adjacencyList.containsKey(i)) {
          break;
        } else {
          addEdge(source, i);
        }
      }
    }
  }

  public Set<Integer> getAdjacentNodes(int source) {
    return adjacencyList.get(source);
  }

  public List<Integer> bfs(int start) {
    // Create a queue and add start element in it.
    Queue<Integer> queue = new LinkedList<Integer>();
    queue.add(start);

    // Create visited boolean array and set start index to true since start node is visited.
    boolean[] visited = new boolean[adjacencyList.size()];
    visited[start] = true;

    // result contains the output BFS traversal
    List<Integer> result = new ArrayList<Integer>();

    // Remove the element from the queue and put it in the output sequence. Then for each adjacent
    // node of the element, check if it's visited. If it's not, make it visited and add it in the
    // queue. Keep doing this until the queue is not empty.
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
    // Return BFS traversal
    return result;
  }

  public List<Integer> dfs(int start) {
    // Create a stack, result list and visited array
    Stack<Integer> stack = new Stack<Integer>();
    List<Integer> result = new ArrayList<Integer>();
    boolean[] visited = new boolean[adjacencyList.size()];

    // Push the start element to the stack, add it to the output sequence, and mark it as visited.
    stack.push(start);
    result.add(start);
    visited[start] = true;

    while (!stack.isEmpty()) {
      // Check the top element in the stack and get its adjacent nodes
      int node = stack.peek();
      Set<Integer> adjacentNodes = getAdjacentNodes(node);

      // Get an iterator to the set.
      Iterator<Integer> itr = adjacentNodes.iterator();
      if (itr.hasNext()) {
        // If it is a valid iterator (i.e. the adjacent node exists), dereference it to an integer
        // and remove it so that next element will be the next adjacent node. NOTE : Unlike BFS,
        // don't do a for each loop on adjacent nodes.
        int adjNode = itr.next();
        itr.remove();

        // If this adjacent node is not visited, push it to the stack, add it to the output sequence
        // and mark it as visited.
        if (!visited[adjNode]) {
          stack.push(adjNode);
          result.add(adjNode);
          visited[adjNode] = true;
        }
      } else {
        // If it is an invalid iterator (i.e. adjacent node doesn't exist), pop element from the
        // stack.
        stack.pop();
      }
    }

    // Return result
    return result;
  }
}
