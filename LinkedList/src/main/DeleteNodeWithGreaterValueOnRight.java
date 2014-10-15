package main;

import main.LinkedList.ListNode;

/**
 * Given a singly linked list, remove all the nodes which have a greater value on right side.
 * 
 * Examples: a) The list 12->15->10->11->5->6->2->3->NULL should be changed to 15->11->6->3->NULL.
 * Note that 12, 10, 5 and 2 have been deleted because there is a greater value on the right side.
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class DeleteNodeWithGreaterValueOnRight {
  public ListNode head;
  public ListNode end;

  public DeleteNodeWithGreaterValueOnRight() {
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

  public void delete() {
    // Reverse the list, delete lesser elements and the reverse again
    reverse();
    deleteLesserNodes();
    reverse();
  }

  private void deleteLesserNodes() {
    ListNode current = head;
    ListNode max = head;
    while (current != null && current.next != null) {
      // If next node is smaller than max, delete next node
      if (current.next.data < max.data) {
        ListNode temp = current.next;
        current.next = temp.next;
      }
      current = current.next;
      max = current;
    }
  }

  private void reverse() {
    ListNode current = head;
    ListNode prev = null;
    ListNode next = null;
    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    // Update the head
    head = prev;
  }
}
