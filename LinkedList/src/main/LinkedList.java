package main;

public class LinkedList {

  // Internal helper class for a node
  public static class ListNode {
    public final int data;
    public ListNode next;

    public ListNode(int data) {
      this.data = data;
    }
  }

  public ListNode head;
  public ListNode end;

  public LinkedList() {
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

  public void print() {
    ListNode temp = head;
    while (temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
    System.out.println("");
  }

  public void delete(ListNode node) {
    if (isEmpty()) {
      return;
    }

    // First element of the list
    if (node == head) {
      head = head.next;
      return;
    }

    // Intermediate and last element
    ListNode temp = head;
    while (temp != null) {
      if (temp.next != null && node.data == temp.next.data) {
        temp.next = temp.next.next;
        return;
      } else {
        temp = temp.next;
      }
    }
  }

  public boolean isEmpty() {
    return head == null;
  }

  /**
   * <pre>
   * Given a singly linked list, write a function to swap elements pairwise. For example, if the linked
   * list is 1->2->3->4->5->6->7 then the function should change it to 2->1->4->3->6->5->7, and if the
   * linked list is 1->2->3->4->5->6 then the function should change it to 2->1->4->3->6->5
   * </pre>
   * 
   * @author onkar.deshpande@gmail.com (Onkar Deshpande)
   * 
   */
  public void pairWiseSwap() {
    if (head == null || head.next == null) {
      return;
    }
    // In above example, previous points to (->) 1, current-> 2 and head->1
    ListNode previous = head;
    ListNode current = head.next;

    // Update head of the new linked list, head->2
    head = current;

    while (true) {
      // next-> 3
      ListNode next = current.next;
      // Make 2's next point to 1 and so on...
      current.next = previous;

      // This is the end of the linked list condition. next.next == null when there are odd numbers,
      // next == null when there are even number of nodes in the linked list.
      if (next == null || next.next == null) {
        // Set 5's next to 7 when there's 7 in the list. If it contains only upto 6 nodes, then set
        // 5's next to null, and break since the linked list has ended.
        previous.next = next;
        break;
      }

      // Update 1's next to point to 4 and so on...
      previous.next = next.next;

      // When we come here, 2's next will be pointing to 1, and 1's next will be pointing to 4. To
      // continue, set previous->3 and current->4 and so on...
      previous = next;
      current = previous.next;
    }
  }
}
