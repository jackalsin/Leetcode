package interviews.linkedin._460_LFU_Cache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/14/18
 */
class LFUCacheTest {
  private LFUCache cache;

  @BeforeEach
  void setUp() {
    cache = new LFUCache(2);
  }

  @Test
  void testOnlineCase() {
    cache.put(1, 1);
    cache.put(2, 2);
    assertEquals(1, cache.get(1));       // returns 1
    cache.put(3, 3);    // evicts key 2
    assertEquals(-1, cache.get(2));       // returns -1 (not found)
    assertEquals(3, cache.get(3));       // returns -1 (not found)
    cache.put(4, 4);    // evicts key 1
    assertEquals(-1, cache.get(1));       // returns -1 (not found)
    assertEquals(3, cache.get(3));       // returns 3
    assertEquals(4, cache.get(4));       // returns 4
  }

  @Test
  void testEmpty() {
    cache = new LFUCache(0);
    cache.put(0, 0);
    cache.get(0);
  }

  @Test
  void testFailedCase1() {
    cache.put(1, 1);
    cache.put(2, 2);
    assertEquals(1, cache.get(1));
    cache.put(3, 3);
    assertEquals(-1, cache.get(2));
    assertEquals(3, cache.get(3));
    cache.put(4, 4);
    assertEquals(-1, cache.get(1));
    assertEquals(3, cache.get(3));
    assertEquals(4, cache.get(4));

  }

  @Test
  void testFailedCase2() {
//    ["LFUCache", "put", "put", "get", "get", "put", "get", "get", "get"]
//[[2],[2, 1],[3, 2],[3],[2],[4, 3],[2],[3],[4]]

    cache.put(2, 1);
    cache.put(3, 2);
    assertEquals(2, cache.get(3));
    assertEquals(1, cache.get(2));
    cache.put(4, 3);
    assertEquals(1, cache.get(2));
    assertEquals(-1, cache.get(3));
    assertEquals(3, cache.get(4));
  }
}