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

  @Test
  public void testReverseAlternateAndAppendEvenNodes() {
    ll.reverseAlternateAndAppend();
    Assert.assertEquals(ll.head.data, 1);
    Assert.assertEquals(ll.head.next.data, 3);
    Assert.assertEquals(ll.head.next.next.data, 5);
    Assert.assertEquals(ll.head.next.next.next.data, 6);
    Assert.assertEquals(ll.head.next.next.next.next.data, 4);
    Assert.assertEquals(ll.head.next.next.next.next.next.data, 2);
  }
  
  @Test
  public void testReverseAlternateAndAppendOddNodes() {
    ll.insert(7);
    ll.reverseAlternateAndAppend();
    Assert.assertEquals(ll.head.data, 1);
    Assert.assertEquals(ll.head.next.data, 3);
    Assert.assertEquals(ll.head.next.next.data, 5);
    Assert.assertEquals(ll.head.next.next.next.data, 7);
    Assert.assertEquals(ll.head.next.next.next.next.data, 6);
    Assert.assertEquals(ll.head.next.next.next.next.next.data, 4);
    Assert.assertEquals(ll.head.next.next.next.next.next.next.data, 2);
  }

  @Test
  public void testAlternateMerge() {
    LinkedList l2 = new LinkedList();
    l2.insert(10);
    l2.insert(11);
    
    ll.mergeAlternate(l2);
    Assert.assertEquals(ll.head.data, 1);
    Assert.assertEquals(ll.head.next.data, 10);
    Assert.assertEquals(ll.head.next.next.data, 2);
    Assert.assertEquals(ll.head.next.next.next.data, 11);
    Assert.assertEquals(ll.head.next.next.next.next.data, 3);
    Assert.assertEquals(ll.head.next.next.next.next.next.data, 4);
    Assert.assertEquals(ll.head.next.next.next.next.next.next.data, 5);
    Assert.assertEquals(ll.head.next.next.next.next.next.next.next.data, 6);
    Assert.assertNull(l2.head);
  }

  @Test
  public void testAlternateMerge2() {
    LinkedList l2 = new LinkedList();
    l2.insert(10);
    l2.insert(11);
    l2.insert(12);
    l2.insert(13);

    ll.delete(new ListNode(4));
    ll.delete(new ListNode(5));
    ll.delete(new ListNode(6));

    ll.mergeAlternate(l2);

    Assert.assertEquals(ll.head.data, 1);
    Assert.assertEquals(ll.head.next.data, 10);
    Assert.assertEquals(ll.head.next.next.data, 2);
    Assert.assertEquals(ll.head.next.next.next.data, 11);
    Assert.assertEquals(ll.head.next.next.next.next.data, 3);
    Assert.assertEquals(ll.head.next.next.next.next.next.data, 12);
    Assert.assertEquals(ll.head.next.next.next.next.next.next.data, 13);
  }

  @Test
  public void testAlternateMerge3() {
    LinkedList l2 = new LinkedList();
    l2.insert(11);
    l2.insert(12);
    l2.insert(13);
    l2.insert(14);
    l2.insert(15);
    l2.insert(16);

    ll.mergeAlternate(l2);

    Assert.assertEquals(ll.head.data, 1);
    Assert.assertEquals(ll.head.next.data, 11);
    Assert.assertEquals(ll.head.next.next.data, 2);
    Assert.assertEquals(ll.head.next.next.next.data, 12);
    Assert.assertEquals(ll.head.next.next.next.next.data, 3);
    Assert.assertEquals(ll.head.next.next.next.next.next.data, 13);
    Assert.assertEquals(ll.head.next.next.next.next.next.next.data, 4);
    Assert.assertEquals(ll.head.next.next.next.next.next.next.next.data, 14);
    Assert.assertEquals(ll.head.next.next.next.next.next.next.next.next.data, 5);
    Assert.assertEquals(ll.head.next.next.next.next.next.next.next.next.next.data, 15);
    Assert.assertEquals(ll.head.next.next.next.next.next.next.next.next.next.next.data, 6);
    Assert.assertEquals(ll.head.next.next.next.next.next.next.next.next.next.next.next.data, 16);
  }

  @Test
  public void testLoop() {
    ll.head.next.next.next.next.next.next = ll.head.next;
    Assert.assertTrue(ll.hasLoop());
    ll.head.next.next.next.next.next.next = null;
    Assert.assertFalse(ll.hasLoop());
  }

  @Test
  public void removeLoop() {
    ll.delete(new ListNode(6));
    ll.head.next.next.next.next.next = ll.head.next.next;
    ll.removeLoop();
    Assert.assertEquals(ll.head.data, 1);
    Assert.assertEquals(ll.head.next.data, 2);
    Assert.assertEquals(ll.head.next.next.data, 3);
    Assert.assertEquals(ll.head.next.next.next.data, 4);
    Assert.assertEquals(ll.head.next.next.next.next.data, 5);
    Assert.assertNull(ll.head.next.next.next.next.next);
  }

  @Test
  public void testIntersection() {
    LinkedList l2 = new LinkedList();
    l2.insert(2);
    l2.insert(3);
    l2.insert(7);
    LinkedList result = new LinkedList();
    ll.intersection(ll.head, l2.head, result);
    Assert.assertEquals(2, result.head.data);
    Assert.assertEquals(3, result.head.next.data);
  }

  @Test
  public void testUnion() {
    LinkedList l2 = new LinkedList();
    l2.insert(1);
    l2.insert(7);
    LinkedList result = new LinkedList();
    ll.union(ll.head, l2.head, result);
    Assert.assertEquals(1, result.head.data);
    Assert.assertEquals(2, result.head.next.data);
    Assert.assertEquals(3, result.head.next.next.data);
    Assert.assertEquals(4, result.head.next.next.next.data);
    Assert.assertEquals(5, result.head.next.next.next.next.data);
    Assert.assertEquals(6, result.head.next.next.next.next.next.data);
    Assert.assertEquals(7, result.head.next.next.next.next.next.next.data);
  }

}
