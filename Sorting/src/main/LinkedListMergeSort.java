package main;

public class LinkedListMergeSort {

  public ListNode mergeSortList(ListNode head) {
    // Base condition of the recursion. If the list is empty or if only one element is present,
    // return the element
    if (head == null || head.next == null) {
      return head;
    }

    // Use slow and fast pointer method. Slow points to the first element and fast points to the
    // second element. Then onwards, fast is incremented twice for each increment in slow pointer.
    // This way, we can split the linked list in 2 halves.
    ListNode slow = head;
    ListNode fast = head.next;
    while (fast != null) {
      fast = fast.next;
      if (fast != null) {
        slow = slow.next;
        fast = fast.next;
      }
    }

    // Create two lists, slow becomes the head of first half and fast becomes the head of the second
    // half. Both halves are passed to the recursion.
    fast = slow.next;
    slow.next = null;
    slow = head;
    ListNode h1 = mergeSortList(slow);
    ListNode h2 = mergeSortList(fast);

    // Merge the result of sorted lists
    ListNode result = merge(h1, h2);
    return result;
  }

  private ListNode merge(ListNode h1, ListNode h2) {
    ListNode p1 = h1;
    ListNode p2 = h2;
    // Fake head is the previous node of head of the merged linked list. This trick is used when you
    // don't want to allocate separate memory for storing the merging result.
    ListNode fakeHead = new ListNode(0);
    ListNode p = fakeHead;
    while (p1 != null && p2 != null) {
      if (p1.value <= p2.value) {
        p.next = p1;
        p1 = p1.next;
      } else {
        p.next = p2;
        p2 = p2.next;
      }
      p = p.next;
    }
    if (p1 != null) {
      // Attach remaining elements to the result
      p.next = p1;
    }
    if (p2 != null) {
      // Attach remaining elements to the result
      p.next = p2;
    }
    // Return fake head's next element which is the actual head of the merged linked list.
    return fakeHead.next;
  }

}
