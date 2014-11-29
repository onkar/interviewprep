package test;

import java.io.File;
import java.io.IOException;

import main.BinarySearchTree;
import main.BinarySearchTree.BSTNode;
import main.SerializeDeserializeBST;

import org.junit.Assert;
import org.junit.Test;

public class SerializeDeserializeBSTTest {
  @Test
  public void test() {
    SerializeDeserializeBST s = new SerializeDeserializeBST();
    BinarySearchTree bst = new BinarySearchTree();
    bst.insert(30);
    bst.insert(10);
    bst.insert(20);
    bst.insert(50);
    bst.insert(45);
    bst.insert(35);
    try {
      s.serializeBST(bst.root(), "/tmp/serialized");
    } catch (IOException e) {
      System.out.println("File not found");
      return;
    }
    try {
      BSTNode root = s.deserializeBST("/tmp/serialized");
      Assert.assertEquals(30, root.data);
      Assert.assertEquals(10, root.left.data);
      Assert.assertEquals(20, root.left.right.data);
      Assert.assertEquals(50, root.right.data);
      Assert.assertEquals(45, root.right.left.data);
      Assert.assertEquals(35, root.right.left.left.data);
    } catch (IOException e) {
      System.out.println("File not found");
      return;
    }

    File file = new File("/tmp/serialized");
    file.delete();
  }
}
