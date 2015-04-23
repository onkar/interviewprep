package main;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class CloneGraph {
  public static Map<Integer, Node> cloneGraphDFS(Map<Integer, Node> inputGraph) {

    System.out.println("Graph is :");
    printGraph(inputGraph);

    Map<Integer, Node> result = new HashMap<Integer, Node>();
    Iterator<Node> it = inputGraph.values().iterator();

    while (it.hasNext()) {
      Node currentNode = it.next();
      Map<Node, Node> visitedMap = new HashMap<Node, Node>();
      Node currentClonedNode = dfsCopy(currentNode, visitedMap);
      result.put(currentClonedNode.label, currentClonedNode);
    }

    System.out.println("Cloned Graph is :");
    printGraph(result);

    return result;
  }

  private static void printGraph(Map<Integer, Node> result) {
    for (Entry<Integer, Node> e : result.entrySet()) {
      int key = e.getKey();
      Node value = e.getValue();
      System.out.print(key + "=> ");
      for (Node u : value.neighbors) {
        System.out.print(u.label + " ");
      }
      System.out.println();
    }
  }

  private static Node dfsCopy(Node node, Map<Node, Node> map) {
    if (map.containsKey(node)) {
      return map.get(node);
    }
    Node copy = new Node(node.label);
    map.put(node, copy);
    for (int i = 0; i < node.neighbors.size(); i++) {
      copy.neighbors.add(dfsCopy(node.neighbors.get(i), map));
    }
    return copy;
  }
}
