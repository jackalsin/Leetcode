package google._460_LFU_Cache;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LFUCacheTest {
  private LFUCache cache;

  @Before
  public void setUp() throws Exception {
    cache = new LFUCache(2);
  }

  @Test
  public void testOnlineCase() throws Exception {
    cache.put(1, 1);
    cache.put(2, 2);
    assertEquals(1, cache.get(1));       // returns 1
    cache.put(3, 3);    // evicts key 2
    assertEquals(-1, cache.get(2));       // returns -1 (not found)
    assertEquals(3, cache.get(3));       // returns -1 (not found)
    cache.put(4, 4);    // evicts key 1
    cache.displayHead();

    assertEquals(-1, cache.get(1));       // returns -1 (not found)
    assertEquals(3, cache.get(3));       // returns 3

    cache.displayHead();
    assertEquals(4, cache.get(4));       // returns 4
    cache.displayHead();
  }

  @Test
  public void testEmpty() throws Exception {
    cache = new LFUCache(0);
    cache.put(0, 0);
    cache.get(0);
  }

  @Test
  public void testFailedCase1() throws Exception {
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
    cache.displayHead();
  }
}
