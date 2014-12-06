package main;

public class LinkedListRandomPtr {
  public int data;
  public LinkedListRandomPtr next;
  public LinkedListRandomPtr random;

  public LinkedListRandomPtr(int data) {
    this.data = data;
    this.next = null;
    this.random = null;
  }
}
