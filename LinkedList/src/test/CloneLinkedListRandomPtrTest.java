package test;

import junit.framework.Assert;
import main.CloneLinkedListRandomPtr;
import main.LinkedListRandomPtr;

import org.junit.Test;

public class CloneLinkedListRandomPtrTest {
  @Test
  public void test() {
    LinkedListRandomPtr head = new LinkedListRandomPtr(1);
    head.next = new LinkedListRandomPtr(2);
    head.next.next = new LinkedListRandomPtr(3);
    head.next.next.next = new LinkedListRandomPtr(4);
    head.next.next.next.next = new LinkedListRandomPtr(5);

    head.random = head.next.next;
    head.next.random = head;
    head.next.next.random = head.next.next.next.next;
    head.next.next.next.random = head.next.next;
    head.next.next.next.next.random = head.next;

    CloneLinkedListRandomPtr c = new CloneLinkedListRandomPtr();
    LinkedListRandomPtr result = c.clone(head);
    Assert.assertEquals(1, result.data);
    Assert.assertEquals(2, result.next.data);
    Assert.assertEquals(3, result.next.next.data);
    Assert.assertEquals(4, result.next.next.next.data);
    Assert.assertEquals(5, result.next.next.next.next.data);

    Assert.assertEquals(3, result.random.data);
    Assert.assertEquals(1, result.next.random.data);
    Assert.assertEquals(5, result.next.next.random.data);
    Assert.assertEquals(3, result.next.next.next.random.data);
    Assert.assertEquals(2, result.next.next.next.next.random.data);

  }
}
