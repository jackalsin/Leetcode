package interviews.uber._146_LRU_Cache;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LRUCacheTest {
  private LRUCache cache;

  @Test
  void testOnlineCase() {
    cache = new LRUCache(2);
    cache.put(1, 1);
    cache.put(2, 2);
    assertEquals(1, cache.get(1));       // returns 1
    cache.put(3, 3);    // evicts key 2
    assertEquals(-1, cache.get(2));       // returns -1 (not found)
    cache.put(4, 4);    // evicts key 1
    assertEquals(-1, cache.get(1));       // returns -1 (not found)
    assertEquals(3, cache.get(3));       // returns 3
    assertEquals(4, cache.get(4));       // returns 4
  }

  @Test
  void testFailedCase2() {
    cache = new LRUCache(2);
    assertEquals(-1, cache.get(2));
    cache.put(2, 6);
    assertEquals(-1, cache.get(1));
    cache.put(1, 5);
    cache.put(1, 2);
    assertEquals(2, cache.get(1));
    assertEquals(6, cache.get(2));
  }

  /**
   * Key2 val = 19
   * Key3 val = 17
   * Key5 val = 5
   * Key9 val = 12
   * Key9 val = 3
   * Key10 val = 5
   * Key10 val = 5
   * Key3 val = 1
   * Key1 val = 30
   * Key5 val = 5
   * Key4 val = 30
   * Key10 val = 11
   * Key12 val = 24
   *
   * @throws Exception
   */
  @Test
  void testFailedCase() {
//    ["LRUCache","put","put","put","put","put","get","put","get","get","put","get","put","put","put","get","put","get","get","get","get","put","put","get","get","get","put","put","get","put","get","put","get","get","get","put","put","put","get","put","get","get","put","put","get","put","put","put","put","get","put","put","get","put","put","get","put","put","put","put","put","get","put","put","get","put","get","get","get","put","get","get","put","put","put","put","get","put","put","put","put","get","get","get","put","put","put","get","put","put","put","get","put","put","put","get","get","get","put","put","put","put","get","put","put","put","put","put","put","put"]
//[[10],[10,13],[3,17],[6,11],[10,5],[9,10],[13],[2,19],[2],[3],[5,25],[8],[9,22],[5,5],[1,30],[11],[9,12],[7],[5],[8],[9],[4,30],[9,3],[9],[10],[10],[6,14],[3,1],[3],[10,11],[8],[2,14],[1],[5],[4],[11,4],[12,24],[5,18],[13],[7,23],[8],[12],[3,27],[2,12],[5],[2,9],[13,4],[8,18],[1,7],[6],[9,29],[8,21],[5],[6,30],[1,12],[10],[4,15],[7,22],[11,26],[8,17],[9,29],[5],[3,4],[11,30],[12],[4,29],[3],[9],[6],[3,4],[1],[10],[3,29],[10,28],[1,20],[11,13],[3],[3,12],[3,8],[10,9],[3,26],[8],[7],[5],[13,17],[2,27],[11,15],[12],[9,19],[2,15],[3,16],[1],[12,17],[9,1],[6,19],[4],[5],[5],[8,1],[11,7],[5,2],[9,28],[1],[2,2],[7,4],[4,22],[7,24],[9,26],[13,28],[11,26]]
    cache = new LRUCache(10);
    cache.put(10, 13);
    cache.put(3, 17);
    cache.put(6, 11);
    cache.put(10, 5);
    cache.put(9, 10); // 5
    cache.get(13);
    cache.put(2, 19);
    cache.get(2);
    cache.get(3);
    cache.put(5, 25);
    cache.get(8);
    cache.put(9, 22);
    cache.put(5, 5);
    cache.put(1, 30); // 10
    cache.get(11);
    cache.put(9, 12);
    cache.get(7);
    cache.get(5);
    cache.get(8);
    cache.get(9);
    cache.put(4, 30);
    cache.put(9, 3);
    cache.get(9);
    cache.get(10);
    cache.get(10);
    cache.put(6, 14);
    cache.put(3, 1);
    cache.get(3);
    cache.put(10, 11);
    cache.get(8);
    cache.put(2, 14);
    cache.get(1);
    cache.get(5);
    cache.get(4);
    cache.put(11, 4);
    cache.put(12, 24);
    cache.put(5, 18);
    cache.get(13);
    cache.put(7, 23);
    cache.get(8);
    cache.get(12);
    cache.put(3, 27);
  }
}