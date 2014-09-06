package test;

import static org.junit.Assert.fail;
import main.LinkedListMergeSort;
import main.ListNode;

import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {
  private ListNode n1;

  @Before
  public void setup() throws Exception {
    n1 = new ListNode(15);
    ListNode n2 = new ListNode(2);
    ListNode n3 = new ListNode(11);

    n1.next = n2;
    n2.next = n3;
    n3.next = null;
  }
  
  @Test
  public void testLinkedListMergeSort() throws Exception {
    LinkedListMergeSort llm = new LinkedListMergeSort();
    ListNode result = llm.mergeSortList(n1);
    ListNode temp = result;
    while (temp.next != null) {
      if (temp.value > temp.next.value) {
        fail("LinkedList is not sorted...");
      }
      temp = temp.next;
    }
  }
}
