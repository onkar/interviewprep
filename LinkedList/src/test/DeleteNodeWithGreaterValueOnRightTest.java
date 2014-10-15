package test;

import junit.framework.Assert;
import main.DeleteNodeWithGreaterValueOnRight;

import org.junit.Test;

public class DeleteNodeWithGreaterValueOnRightTest {
  private DeleteNodeWithGreaterValueOnRight l;

  @Test
  public void test() {
    l = new DeleteNodeWithGreaterValueOnRight();
    l.insert(12);
    l.insert(15);
    l.insert(10);
    l.insert(11);
    l.insert(5);
    l.insert(6);
    l.insert(2);
    l.insert(3);

    l.delete();

    Assert.assertEquals(15, l.head.data);
    Assert.assertEquals(11, l.head.next.data);
    Assert.assertEquals(6, l.head.next.next.data);
    Assert.assertEquals(3, l.head.next.next.next.data);
    Assert.assertNull(l.head.next.next.next.next);
  }
}
