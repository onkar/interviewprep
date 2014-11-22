package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class UndirectedGraphOperations {

  public static List<Node> bfs(Map<Integer, Node> undirectedGraph, Node start) {
    // Create a queue and add start element in it.
    Queue<Node> queue = new LinkedList<Node>();
    queue.add(start);

    // Create visited boolean array and set start index to true since start node is visited.
    boolean[] visited = new boolean[undirectedGraph.size()];
    visited[start.label] = true;

    // result contains the output BFS traversal
    List<Node> result = new ArrayList<Node>();

    // Remove the element from the queue and put it in the output sequence. Then for each adjacent
    // node of the element, check if it's visited. If it's not, make it visited and add it in the
    // queue. Keep doing this until the queue is not empty.
    while (!queue.isEmpty()) {
      Node node = queue.remove();
      result.add(node);
      for (Node adjNode : node.neighbors) {
        if (!visited[adjNode.label]) {
          visited[adjNode.label] = true;
          queue.add(adjNode);
        }
      }
    }
    // Return BFS traversal
    return result;
  }

  public static List<Node> dfs(Map<Integer, Node> undirectedGraph, Node start) {
    // Create a stack, result list and visited array
    Stack<Node> stack = new Stack<Node>();
    List<Node> result = new ArrayList<Node>();
    boolean[] visited = new boolean[undirectedGraph.size()];

    // Push the start element to the stack, add it to the output sequence, and mark it as visited.
    stack.push(start);
    result.add(start);
    visited[start.label] = true;

    while (!stack.isEmpty()) {
      // Check the top element in the stack and get its adjacent nodes
      Node node = stack.peek();
      List<Node> adjacentNodes = node.neighbors;

      // Get an iterator to the list of neighbors.
      Iterator<Node> itr = adjacentNodes.iterator();
      if (itr.hasNext()) {
        // If it is a valid iterator (i.e. the adjacent node exists), dereference it to an integer
        // and remove it so that next element will be the next adjacent node. NOTE : Like BFS,
        // don't do a for each loop on adjacent nodes.
        Node adjNode = itr.next();
        itr.remove();

        // If this adjacent node is not visited, push it to the stack, add it to the output sequence
        // and mark it as visited.
        if (!visited[adjNode.label]) {
          stack.push(adjNode);
          result.add(adjNode);
          visited[adjNode.label] = true;
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
