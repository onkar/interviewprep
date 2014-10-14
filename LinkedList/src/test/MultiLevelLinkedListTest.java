package test;

import main.MultiLevelLinkedList;
import main.MultiLevelLinkedList.ListNode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MultiLevelLinkedListTest {
  private MultiLevelLinkedList mll;

  @Before
  public void setup() {
    mll = new MultiLevelLinkedList();
    mll.insert(10);
    mll.insert(5);
    mll.insert(12);
    mll.insert(7);
    mll.insert(11);

    MultiLevelLinkedList m1 = new MultiLevelLinkedList();
    m1.insert(4);
    m1.insert(20);
    m1.insert(13);

    MultiLevelLinkedList m2 = new MultiLevelLinkedList();
    m2.insert(17);
    m2.insert(6);

    MultiLevelLinkedList m3 = new MultiLevelLinkedList();
    m3.insert(9);
    m3.insert(8);

    MultiLevelLinkedList m4 = new MultiLevelLinkedList();
    m4.insert(19);
    m4.insert(15);

    // Set child pointers
    mll.head.child = m1.head;
    mll.head.next.next.next.child = m2.head;

    m1.head.next.child = new ListNode(2);
    m1.head.next.next.child = new ListNode(16);
    m1.head.next.next.child.child = new ListNode(3);

    m2.head.child = m3.head;

    m3.head.child = m4.head;
  }

  @Test
  public void testFlattening() {
    mll.flatten();
    Assert.assertEquals(10, mll.head.data);
    Assert.assertEquals(5, mll.head.next.data);
    Assert.assertEquals(12, mll.head.next.next.data);
    Assert.assertEquals(7, mll.head.next.next.next.data);
    Assert.assertEquals(11, mll.head.next.next.next.next.data);
    Assert.assertEquals(4, mll.head.next.next.next.next.next.data);
    Assert.assertEquals(20, mll.head.next.next.next.next.next.next.data);
    Assert.assertEquals(13, mll.head.next.next.next.next.next.next.next.data);
    Assert.assertEquals(17, mll.head.next.next.next.next.next.next.next.next.data);
    Assert.assertEquals(6, mll.head.next.next.next.next.next.next.next.next.next.data);
    Assert.assertEquals(2, mll.head.next.next.next.next.next.next.next.next.next.next.data);
    Assert.assertEquals(16, mll.head.next.next.next.next.next.next.next.next.next.next.next.data);
    Assert.assertEquals(9,
        mll.head.next.next.next.next.next.next.next.next.next.next.next.next.data);
    Assert.assertEquals(8,
        mll.head.next.next.next.next.next.next.next.next.next.next.next.next.next.data);
    Assert.assertEquals(3,
        mll.head.next.next.next.next.next.next.next.next.next.next.next.next.next.next.data);
    Assert.assertEquals(19,
        mll.head.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.data);
    Assert
        .assertEquals(
            15,
            mll.head.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.data);
    Assert
        .assertNull(mll.head.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next);
  }
}
