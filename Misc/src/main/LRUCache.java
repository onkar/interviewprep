package main;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
  // Internal class
  private static class DoublyLinkedListNode {
    public int key, value;
    public DoublyLinkedListNode prev, next;

    DoublyLinkedListNode(int key, int value) {
      this.key = key;
      this.value = value;
      // No need to allocate memory to prev and next because they are just used to save the existing
      // nodes
    }
  }

  // LRUCache members
  private final Map<Integer, DoublyLinkedListNode> map;
  private DoublyLinkedListNode head, tail;
  private final int capacity;
  private int size;

  /**
   * <pre>
   * LRU cache is internally a doubly linked list with an additional hashmap for the quicker lookup.
   * Each node's address is saved in the hashmap as a value. Whenever a get is called, and if the
   * element is present in the map, the element is removed from its existing position in the doubly
   * linked list and moved to the head of the linked list. If the element is not found in the map on
   * get(), we return -1. 
   * 
   * For putting element in the cache, if it's already found in the map, we update its old value and
   * move the updated node to the head of the linked list. If it's not found in the map, and the size
   * is more than the capacity, we evict the entry from tail and update the head of linked list with
   * the new value of the node.
   * </pre>
   * 
   * @param capacity
   */
  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.size = 0;
    this.map = new HashMap<Integer, DoublyLinkedListNode>();
    // No need to allocated memory to head an tail because they act like indexes and for saving the
    // existing nodes
  }

  public void set(int key, int value) {
    if (map.containsKey(key)) {
      // If the key is found, replace the existing value by a new one
      DoublyLinkedListNode oldNode = map.get(key);
      oldNode.value = value;
      // Remove the node from it's existing position and set it as the head of the doubly linked
      // list
      removeNode(oldNode);
      setHead(oldNode);
    } else {
      if (size < capacity) {
        // Don't evict, just update the size
        size++;
      } else {
        // Evict the element from the tail and update tail
        map.remove(tail.key);
        tail = tail.prev;
        if (tail != null) {
          tail.next = null;
        }
      }
      // Allocate the new node with given value and set it as the head of the linked list. Also
      // update the map with this new node.
      DoublyLinkedListNode newNode = new DoublyLinkedListNode(key, value);
      setHead(newNode);
      map.put(key, newNode);
    }
  }

  public int get(int key) {
    if (map.containsKey(key)) {
      DoublyLinkedListNode recent = map.get(key);
      removeNode(recent);
      setHead(recent);
      return recent.value;
    } else {
      return -1;
    }
  }

  private void setHead(DoublyLinkedListNode node) {
    node.next = head;
    node.prev = null;
    if (head != null) {
      head.prev = node;
    }
    head = node;
    if (tail == null) {
      tail = node;
    }
  }

  private void removeNode(DoublyLinkedListNode node) {
    DoublyLinkedListNode prev = node.prev;
    DoublyLinkedListNode next = node.next;
    if (prev != null) {
      prev.next = next;
    } else {
      head = next;
    }
    if (next != null) {
      next.prev = prev;
    } else {
      tail = prev;
    }
  }

}
