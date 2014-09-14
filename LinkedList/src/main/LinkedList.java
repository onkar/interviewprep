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

  /**
   * <pre>
   * Given a linked list, reverse alternate nodes and append them to end of list. Extra allowed space is O(1)
   * Examples -
   * 
   * Input List:  1->2->3->4->5->6
   * Output List: 1->3->5->6->4->2
   * 
   * Input List:  12->14->16->18->20
   * Output List: 12->16->20->18->14
   * </pre>
   */
  public void reverseAlternateAndAppend() {
    // Make odd point to the head odd->1
    ListNode odd = head;
    // If there are less than 3 nodes in the linked list, nothing needs to be done
    if (odd == null || odd.next == null || odd.next.next == null) {
      return;
    }
    // Make even point to one node ahead of odd. even->2
    ListNode even = odd.next;
    // Make 1's next point to 3. 1->3
    odd.next = even.next;
    // Make 2's next point to null, since this is the last element of the final list 2->null
    even.next = null;
    // Make odd point to 3 here. odd->3
    odd = odd.next;
    // Two pointers to track even and odd nodes
    ListNode oddTracker = null;
    ListNode evenTracker = null;

    while (true) {
      // oddTracker points to next odd node. oddTracker->5
      oddTracker = odd.next.next;
      // evenTracker points to next even node. evenTracker->4
      evenTracker = odd.next;
      // Make 4's next point to 2. 4->2
      evenTracker.next = even;
      // Update even to point to next even node. even->4
      even = evenTracker;
      if (oddTracker == null) {
        // This is the end of linked list when there are even number of nodes. For example, when odd
        // points to 5 (odd->5), then oddTracker will point to null. That's when we set 6's next to
        // 4, 6->4 and we break out of the loop
        odd.next = even;
        break;
      } else {
        // Increment odd to point to next odd element, otherwise.
        odd.next = oddTracker;
        if (oddTracker.next == null) {
          // Exit condition for odd number of nodes. For example, if we have 7 also, oddTracker
          // points to 7, and 7's next is null. Then make 7's next point to 6. Then break.
          oddTracker.next = even;
          break;
        }
      }
      odd = oddTracker;
    }
  }

  /**
   * Merge alternate nodes in a linked list.
   * 
   * <pre>
   * List1 : 1->2, List2 : 3->4->5, then result : 1->3->2->4->5
   * List1 : 1->2->3, List2: 4->5, then result : 1->4->2->5->3 and make List2=null
   * List1 : 1->2, List2: 3->4, then result : 1->3->2->4
   * </pre>
   * 
   * @param secondList
   */
  public void mergeAlternate(LinkedList secondList) {
    ListNode first = head;
    LinkedList second = secondList;
    ListNode firstCurrent = first, secondCurrent = second.head;
    ListNode firstNext = null;
    ListNode secondNext = null;

    while (firstCurrent.next != null && secondCurrent.next != null) {
      // Keep track of next elements in each linked list
      firstNext = firstCurrent.next;
      secondNext = secondCurrent.next;

      // Assign pointers to each other
      firstCurrent.next = secondCurrent;
      secondCurrent.next = firstNext;

      // Increment
      firstCurrent = firstNext;
      secondCurrent = secondNext;
    }
    
    if (firstCurrent.next == null && secondCurrent.next != null) {
      // Second list is longer, so assign next of first list's last node to second list
      firstCurrent.next = secondCurrent;
    } else if (secondCurrent.next == null && firstCurrent.next != null) {
      // First list is longer, so assign next of second list's last element to next element in first
      // list
      secondCurrent.next = firstCurrent.next;
      // Update first's next to last element in second list
      firstCurrent.next = secondCurrent;
      // Set second list's head to null
      secondList.head = null;
    } else {
      // If both lists are of same length, connect first list's last element to second list's last
      // element
      firstCurrent.next = secondCurrent;
    }
  }

  /**
   * Detect if the linked list has a loop
   * 
   * @return
   */
  public boolean hasLoop() {
    ListNode slow = head;
    ListNode fast = head;
    while (slow != null && fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        return true;
      }
    }
    return false;
  }

  /**
   * Detect and remove the loop in the linked list
   */
  public void removeLoop() {
    ListNode slow = head;
    ListNode fast = head;
    while (slow != null && fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      // Detect the loop
      if (slow == fast) {
        // Set slow to the head of the linked list
        slow = head;
        // Node to track previous of the fast node. Fast node points to some node inside the loop
        ListNode fastPrevious = null;
        // Slow points to head and fast points to some node in the loop, now if we increment both
        // one place at a time, they will meet at the beginning of the loop
        while (slow != fast) {
          slow = slow.next;
          // fastPrevious point to the previous node of the fast node
          fastPrevious = fast;
          fast = fast.next;
        }
        // Set the next of fastPrevious to null so that the linked list ends
        fastPrevious.next = null;
      }
    }
  }

}
