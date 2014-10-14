package main;

/**
 * Flatten a multilevel linked list
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */

public class MultiLevelLinkedList {

  // Internal helper class for a node
  public static class ListNode {
    public final int data;
    public ListNode next;
    public ListNode child;

    public ListNode(int data) {
      this.data = data;
      this.next = null;
    }
  }

  public ListNode head;
  public ListNode end;

  public MultiLevelLinkedList() {
    head = null;
    end = null;
  }

  public void insert(int data) {
    ListNode node = new ListNode(data);
    if (head == null) {
      head = node;
      head.next = null;
      end = head;
    } else {
      end.next = node;
      end = end.next;
      end.next = null;
    }
  }

  public void flatten() {
    if (head == null) {
      return;
    }

    ListNode tail = head;
    // Get to the end of the first level and point tail to the last node
    while (tail.next != null) {
      tail = tail.next;
    }

    // Make current point to the head
    ListNode current = head;
    while (current != tail) {
      if (current.child != null) {
        // If current node has a child, connect tail's next to the child.
        tail.next = current.child;
        // Make temp point to current child
        ListNode temp = current.child;
        // Run through the complete list of child and keep updating temp so that it points to the
        // last element of the current child's list
        while (temp.next != null) {
          temp = temp.next;
        }
        // Update tail and make it point to end of the current child's list
        tail = temp;
      }
      // Go to the next element
      current = current.next;
    }

  }
}
