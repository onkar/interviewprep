package main;

import java.util.StringTokenizer;

import main.BinarySearchTree.BSTNode;

public class SerializeDeserializeBinaryTree {
  public String serialize(BSTNode root) {
    StringBuilder sb = new StringBuilder();
    serialize(root, sb);
    return sb.toString();
  }

  private void serialize(BSTNode root, StringBuilder sb) {
    if (root == null) {
      sb.append("#" + " ");
      return;
    }
    sb.append(root.data + " ");
    serialize(root.left, sb);
    serialize(root.right, sb);
  }

  public BSTNode deserialize(String serializedTree) {
    if (serializedTree == null || serializedTree.length() == 0)
      return null;
    StringTokenizer st = new StringTokenizer(serializedTree, " ");
    return deserialize(st);
  }

  private BSTNode deserialize(StringTokenizer st) {
    if (!st.hasMoreTokens())
      return null;
    String value = st.nextToken();
    if (value.equals("#"))
      return null;
    BSTNode root = new BSTNode(Integer.parseInt(value));
    root.left = deserialize(st);
    root.right = deserialize(st);
    return root;
  }
}
