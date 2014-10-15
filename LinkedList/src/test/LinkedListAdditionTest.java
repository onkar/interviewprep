package test;

import junit.framework.Assert;
import main.LinkedList;
import main.LinkedListAddition;

import org.junit.Test;

public class LinkedListAdditionTest {
  private LinkedListAddition lla;

  @Test
  public void test() {
    LinkedList l1 = new LinkedList();
    l1.insert(5);
    l1.insert(6);
    l1.insert(3);
    LinkedList l2 = new LinkedList();
    l2.insert(8);
    l2.insert(4);
    l2.insert(2);
    lla = new LinkedListAddition();
    LinkedList result = lla.addition(l1.head, l2.head);
    Assert.assertEquals(3, result.head.data);
    Assert.assertEquals(1, result.head.next.data);
    Assert.assertEquals(6, result.head.next.next.data);

    l1 = new LinkedList();
    l1.insert(9);
    l1.insert(9);
    l2 = new LinkedList();
    l2.insert(9);
    l2.insert(9);
    result = lla.addition(l1.head, l2.head);
    Assert.assertEquals(8, result.head.data);
    Assert.assertEquals(9, result.head.next.data);
    Assert.assertEquals(1, result.head.next.next.data);

    l1 = new LinkedList();
    l1.insert(8);
    l1.insert(9);
    l1.insert(1);
    l2 = new LinkedList();
    l2.insert(8);
    l2.insert(9);
    result = lla.addition(l1.head, l2.head);
    Assert.assertEquals(6, result.head.data);
    Assert.assertEquals(9, result.head.next.data);
    Assert.assertEquals(2, result.head.next.next.data);
  }
}
