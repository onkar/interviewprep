package test;

import junit.framework.Assert;
import main.LinkedList;
import main.LinkedList.ListNode;

import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {

  private LinkedList ll;

  @Before
  public void setup() {
    ll = new LinkedList();
    ll.insert(1);
    ll.insert(2);
    ll.insert(3);
    ll.insert(4);
    ll.insert(5);
    ll.insert(6);
  }

  @Test
  public void testInsert() {
    ListNode temp = ll.head;
    int i = 1;
    while (temp != null) {
      Assert.assertEquals(i, temp.data);
      temp = temp.next;
      i++;
    }
  }

  @Test
  public void testDelete() {
    // Delete head node
    ListNode head = ll.head;
    ll.delete(head);
    ListNode temp = ll.head;
    int i = 2;
    while (temp != null) {
      Assert.assertEquals(i, temp.data);
      temp = temp.next;
      i++;
    }

    // Delete intermediate node
    ListNode node = new ListNode(4);
    ll.delete(node);
    Assert.assertEquals(ll.head.data, 2);
    Assert.assertEquals(ll.head.next.data, 3);
    Assert.assertEquals(ll.head.next.next.data, 5);
    Assert.assertEquals(ll.head.next.next.next.data, 6);

    // Delete last node
    node = new ListNode(6);
    ll.delete(node);
    Assert.assertEquals(ll.head.data, 2);
    Assert.assertEquals(ll.head.next.data, 3);
    Assert.assertEquals(ll.head.next.next.data, 5);
    Assert.assertNull(ll.head.next.next.next);
  }
  
  @Test
  public void testPairWiseSwapEvenNodes() {
    ll.pairWiseSwap();
    Assert.assertEquals(ll.head.data, 2);
    Assert.assertEquals(ll.head.next.data, 1);
    Assert.assertEquals(ll.head.next.next.data, 4);
    Assert.assertEquals(ll.head.next.next.next.data, 3);
    Assert.assertEquals(ll.head.next.next.next.next.data, 6);
    Assert.assertEquals(ll.head.next.next.next.next.next.data, 5);
  }

  @Test
  public void testPairWiseSwapOddNodes() {
    ll.insert(7);
    ll.pairWiseSwap();
    Assert.assertEquals(ll.head.data, 2);
    Assert.assertEquals(ll.head.next.data, 1);
    Assert.assertEquals(ll.head.next.next.data, 4);
    Assert.assertEquals(ll.head.next.next.next.data, 3);
    Assert.assertEquals(ll.head.next.next.next.next.data, 6);
    Assert.assertEquals(ll.head.next.next.next.next.next.data, 5);
    Assert.assertEquals(ll.head.next.next.next.next.next.next.data, 7);
  }
}
