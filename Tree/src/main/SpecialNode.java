package main;


public class SpecialNode {
  public int data;
  public SpecialNode left, right, next;

  public SpecialNode(int data) {
    this.data = data;
    this.left = this.right = this.next = null;
  }
}
