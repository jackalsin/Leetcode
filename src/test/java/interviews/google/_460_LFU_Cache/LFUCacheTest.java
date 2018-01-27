package interviews.google._460_LFU_Cache;

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

  @Test
  public void testFailedCase2() throws Exception {
    cache = new LFUCache(10);
//    ["LFUCache","put","put","put","put","put","get","put","get","get","put","get","put","put",
// "put","get","put","get","get","get","get","put","put","get","get","get","put","put","get",
// "put","get","put","get","get","get","put","put","put","get","put","get","get","put","put",
// "get","put","put","put","put","get","put","put","get","put","put","get","put","put","put",
// "put","put","get","put","put","get","put","get","get","get","put","get","get","put","put",
// "put","put","get","put","put","put","put","get","get","get","put","put","put","get","put",
// "put","put","get","put","put","put","get","get","get","put","put","put","put","get","put",
// "put","put","put","put","put","put"]
//[[10],[10,13],[3,17],[6,11],[10,5],[9,10],[13],[2,19],[2],[3],[5,25],[8],[9,22],[5,5],[1,30],
// [11],[9,12],[7],[5],[8],[9],[4,30],[9,3],[9],[10],[10],[6,14],[3,1],[3],[10,11],[8],[2,14],
// [1],[5],[4],[11,4],[12,24],[5,18],[13],[7,23],[8],[12],[3,27],[2,12],[5],[2,9],[13,4],[8,18],
// [1,7],[6],[9,29],[8,21],[5],[6,30],[1,12],[10],[4,15],[7,22],[11,26],[8,17],[9,29],[5],[3,4],
// [11,30],[12],[4,29],[3],[9],[6],[3,4],[1],[10],[3,29],[10,28],[1,20],[11,13],[3],[3,12],[3,8],
// [10,9],[3,26],[8],[7],[5],[13,17],[2,27],[11,15],[12],[9,19],[2,15],[3,16],[1],[12,17],[9,1],
// [6,19],[4],[5],[5],[8,1],[11,7],[5,2],[9,28],[1],[2,2],[7,4],[4,22],[7,24],[9,26],[13,28],[11,
// 26]]
//    [null,null,null,null,null,null,-1,null,19,17,null,-1,null,null,null,-1,null,-1,5,-1,12,
// null,null,3,5,5,null,null,1,null,-1,null,30,5,30,null,null,null,-1,null,-1,24,null,null,18,
// null,null,null,null,14,null,null,18,null,null,11,null,null,null,null,null,18,null,null,-1,
// null,4,29,30,null,12,11,null,null,null,null,29,null,null,null,null,17,-1,18,null,null,null,-1,
// null,null,null,20,null,null,null,29,18,18,null,null,null,null,20,null,null,null,null,null,
// null,null]
//    [null,null,null,null,null,null,-1,null,19,17,null,-1,null,null,null,-1,null,-1,5,-1,12,
// null,null,3,5,5,null,null,1,null,-1,null,30,5,30,null,null,null,-1,null,-1,24,null,null,18,
// null,null,null,null,14,null,null,18,null,null,-1,null,null,null,null,null,18,null,null,24,
// null,4,29,30,null,12,-1,null,null,null,null,-1,null,null,null,null,17,22,18,null,null,null,24,
// null,null,null,20,null,null,null,29,-1,-1,null,null,null,null,-1,null,null,null,null,null,
// null,null]
    cache.put(10, 13);
    cache.put(3, 17);
    cache.put(6, 11);
    cache.put(10, 5);
    cache.put(9, 10);
    assertEquals(-1, cache.get(13));
    cache.put(2, 19);
    assertEquals(19, cache.get(2));
    assertEquals(17, cache.get(3));
    cache.put(5, 25);
    assertEquals(-1, cache.get(8));
    cache.put(9, 22);
    cache.put(5, 5);
    cache.put(1, 30);
    assertEquals(-1, cache.get(11));
    cache.put(9, 12);
    assertEquals(-1, cache.get(7));
    assertEquals(5, cache.get(5));
    assertEquals(-1, cache.get(8));
    assertEquals(12, cache.get(9));
    cache.put(4, 30);
    cache.put(9, 3);
    assertEquals(3, cache.get(9));
    assertEquals(5, cache.get(10));
    assertEquals(5, cache.get(10));
    cache.put(6, 14);
    cache.put(3, 1);
    assertEquals(1, cache.get(3));
    cache.put(10, 11);
    assertEquals(-1, cache.get(8));
    cache.put(2, 14);
    assertEquals(30, cache.get(1));
    assertEquals(5, cache.get(5));
    assertEquals(30, cache.get(4));
    cache.put(11, 4);
    cache.put(12, 24);
    cache.put(5, 18);
    assertEquals(1, cache.get(13));
    cache.put(7, 23);
    assertEquals(-1, cache.get(8));
    cache.put(6, 14);
    cache.put(3, 1);

  }

}
