package main;

import java.util.ArrayList;

public class Node {
  public int label;
  public ArrayList<Node> neighbors;

  public Node(int label) {
    this.label = label;
    this.neighbors = new ArrayList<Node>();
  }
}
