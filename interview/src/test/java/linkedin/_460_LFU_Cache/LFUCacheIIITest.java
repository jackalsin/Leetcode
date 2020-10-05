package linkedin._460_LFU_Cache;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/14/18
 */
class LFUCacheIIITest {
  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase(Class<LFUCache> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    LFUCache cache = solutionClass
        .getConstructor(Integer.TYPE)
        .newInstance(2);
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

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testEmpty(Class<LFUCache> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    LFUCache cache = solutionClass
        .getConstructor(Integer.TYPE)
        .newInstance(0);
    cache.put(0, 0);
    cache.get(0);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCase1(Class<LFUCache> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    LFUCache cache = solutionClass
        .getConstructor(Integer.TYPE)
        .newInstance(2);
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

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCase2(Class<LFUCache> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    LFUCache cache = solutionClass
        .getConstructor(Integer.TYPE)
        .newInstance(2);
//["LFUCache", "put",   "put",  "get",  "get",  "put",  "get",  "get",  "get"]
//[[2],         [2, 1], [3, 2], [3],    [2],    [4, 3], [2],    [3],    [4]]
    cache.put(2, 1);
    cache.put(3, 2);
    assertEquals(2, cache.get(3));
    assertEquals(1, cache.get(2));
    cache.put(4, 3);
    assertEquals(1, cache.get(2));
    assertEquals(-1, cache.get(3));
    assertEquals(3, cache.get(4));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCase3(Class<LFUCache> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    LFUCache cache = solutionClass
        .getConstructor(Integer.TYPE)
        .newInstance(2);
    //["LFUCache","put","put","get","put","put","get"]
    //[[2],[2,1],[2,2],[2],[1,1],[4,1],[2]]
    //    Output:
    //[null,null,null,2,null,null,-1]
    //    Expected:
    //[null,null,null,2,null,null,2]
    cache.put(2, 1);
    cache.put(2, 2);
    assertEquals(2, cache.get(2));
    cache.put(1, 1);
    cache.put(4, 1);
    assertEquals(2, cache.get(2));
  }

  static Stream<Class> solutionStream() {
    return Stream.of(
        LFUCacheI.class,
        LFUCacheII.class,
        LFUCacheIII.class,
        LFUCacheIV.class
    );
  }
}