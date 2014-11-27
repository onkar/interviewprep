package test;

import main.LRUCache;

import org.junit.Assert;
import org.junit.Test;

public class LRUCacheTest {
  @Test
  public void test() {
    LRUCache lru = new LRUCache(5);
    lru.set(0, 0);
    lru.set(1, 1);
    lru.set(2, 2);
    Assert.assertEquals(2, lru.get(2));
    Assert.assertEquals(1, lru.get(1));
    lru.set(3, 3);
    lru.set(4, 4);
    lru.set(5, 5);
    Assert.assertEquals(-1, lru.get(0));
    lru.set(0, 0);
    Assert.assertEquals(-1, lru.get(2));
  }
}
