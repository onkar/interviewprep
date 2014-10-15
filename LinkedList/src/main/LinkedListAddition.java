package main;

import main.LinkedList.ListNode;

/**
 * List1 = 5->6->3 represents number 365 and list2 = 8->4->2 represents 248. So the result should be
 * 3->1->6 which is 613. It should take care of lists with different sizes.
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 * 
 */
public class LinkedListAddition {
  public ListNode head;
  public ListNode end;

  public LinkedListAddition() {
    head = null;
    end = null;
  }

  public LinkedList addition(ListNode list1, ListNode list2) {
    // Initialize carry and sum to zero
    int carry = 0;
    int sum = 0;
    LinkedList result = new LinkedList();
    while (list1 != null && list2 != null) {
      sum = carry + list1.data + list2.data;
      if (sum >= 10) {
        carry = 1;
      } else {
        carry = 0;
      }
      sum = sum % 10;
      result.insert(sum);
      list1 = list1.next;
      list2 = list2.next;
    }
    if (list1 != null) {
      if (carry > 0) {
        // list1 still has some nodes and carry is set to 1, so we need to add current node's data
        // with carry and increment the current list
        result.insert(carry + list1.data);
        list1 = list1.next;
      }
      // Attach remaining nodes of list1 to the result
      result.end = list1;
      // Reset carry so that the last if block doesn't get executed
      carry = 0;
    }
    if (list2 != null) {
      if (carry > 0) {
        result.insert(carry + list2.data);
        list2 = list2.next;
      }
      result.end = list2;
      carry = 0;
    }
    if (list1 == null && list2 == null && carry > 0) {
      // This should get executed only when both lists are of same length but the addition has
      // resulted in a carry
      result.insert(carry);
    }
    return result;
  }
}
