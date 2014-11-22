package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class DirectedGraphOperations {

  public static List<Node> bfs(Map<Integer, Node> undirectedGraph, Node start) {
    Queue<Node> queue = new LinkedList<Node>();
    queue.add(start);
    boolean[] visited = new boolean[undirectedGraph.size()];
    visited[start.label] = true;
    List<Node> result = new ArrayList<Node>();
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
    return result;
  }

  public static List<Node> dfs(Map<Integer, Node> undirectedGraph, Node start) {
    Stack<Node> stack = new Stack<Node>();
    List<Node> result = new ArrayList<Node>();
    boolean[] visited = new boolean[undirectedGraph.size()];

    stack.push(start);
    visited[start.label] = true;
    result.add(start);

    while (!stack.isEmpty()) {
      Node node = stack.peek();
      List<Node> adjacentNodes = node.neighbors;
      Iterator<Node> itr = adjacentNodes.iterator();
      if (itr.hasNext()) {
        Node adjNode = itr.next();
        itr.remove();
        if (!visited[adjNode.label]) {
          stack.push(adjNode);
          result.add(adjNode);
          visited[adjNode.label] = true;
        }
      } else {
        stack.pop();
      }
    }
    return result;
  }

  public static boolean isCyclic(Map<Integer, Node> undirectedGraph, Node start) {
    Stack<Node> stack = new Stack<Node>();
    boolean[] visited = new boolean[undirectedGraph.size()];
    stack.push(start);
    visited[start.label] = true;
    boolean cyclic = false;
    while (!stack.isEmpty()) {
      Node node = stack.peek();
      List<Node> adjacentNodes = node.neighbors;
      Iterator<Node> it = adjacentNodes.iterator();
      if (it.hasNext()) {
        // There are adjacent nodes present
        Node adjNode = it.next();
        it.remove();
        if (!visited[adjNode.label]) {
          visited[adjNode.label] = true;
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

}
