package explore.LRUCache;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/24/2020
 */
class LRUCacheTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase(Class<LRUCache> cacheClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    LRUCache cache = cacheClass.getConstructor(Integer.TYPE).newInstance(2);
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

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Class<LRUCache> cacheClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    LRUCache cache = cacheClass.getConstructor(Integer.TYPE).newInstance(2);
    cache.put(2, 1);
    cache.put(1, 1);
    cache.put(2, 3);
    cache.put(4, 1);
    assertEquals(-1, cache.get(1));
    assertEquals(3, cache.get(2));
  }

  static Stream<Class> solutionProvider() {
    return Stream.of(
        LRUCache.class
    );
  }
}