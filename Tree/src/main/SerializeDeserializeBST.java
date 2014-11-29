package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

import main.BinarySearchTree.BSTNode;

public class SerializeDeserializeBST {
  /**
   * Serialize the binary search tree and write the serialized string in the file
   * 
   * @param root
   * @param filePath
   * @throws IOException
   */
  public void serializeBST(BSTNode root, String filePath) throws IOException {
    String serializedBST = serializeBST(root);
    FileWriter fstream = new FileWriter(filePath);
    BufferedWriter out = new BufferedWriter(fstream);
    out.write(serializedBST);
    out.close();
  }

  private String serializeBST(BSTNode root) {
    // StringBuilder is used to append a character at a time.
    StringBuilder sb = new StringBuilder();
    serializeBST(root, sb);
    return sb.toString();
  }

  private void serializeBST(BSTNode root, StringBuilder sb) {
    if (root == null) {
      // If the leaf node is reached, append "# " to denote the leaf node in serialized string. Note
      // the space " " is used as a separator
      sb.append("#" + " ");
      return;
    }
    // Do a preorder traversal because only preorder traversal gives us the parent node before its
    // children. We need parent first when we deserialize the string into a binary search tree. Note
    // how space " " is used as a separator to differentiate between node with value 12 and nodes
    // with values 1 and 2.
    sb.append(root.data + " ");
    serializeBST(root.left, sb);
    serializeBST(root.right, sb);
  }

  /**
   * Deserialize the tree saved in the given file
   * 
   * @param filePath
   * @return
   * @throws IOException
   */
  public BSTNode deserializeBST(String filePath) throws IOException {
    FileReader fstream = new FileReader(filePath);
    BufferedReader reader = new BufferedReader(fstream);
    // The file will have only one line so, read it and close the reader
    String value = reader.readLine();
    reader.close();
    // Separate out the tokens by using " " as a delimiter
    StringTokenizer st = new StringTokenizer(value, " ");
    // Similar logic for finding if a given binary tree is a binary search tree
    return deserializeBST(st, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private BSTNode deserializeBST(StringTokenizer st, int minValue, int maxValue) throws IOException {
    // Return null if all tokens are already processed
    if (!st.hasMoreTokens())
      return null;
    String value = st.nextToken();
    // If the value is #, we know that it was a leaf node so return null
    if (value.equals("#"))
      return null;
    // Check if the value is in the allowed range. If not, return null
    if (Integer.parseInt(value) > maxValue || Integer.parseInt(value) < minValue)
      return null;
    // Create a tree by recursively calling the same method
    BSTNode root = new BSTNode(Integer.parseInt(value));
    root.left = deserializeBST(st, minValue, root.data);
    root.right = deserializeBST(st, root.data, maxValue);
    return root;
  }
}
