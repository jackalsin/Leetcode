package oracle._146_LRU_Cache;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/19/2019
 */
class LRUCacheTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
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

  static Stream<Class> solutionStream() {
    return Stream.of(
        LRUCacheI.class,
        LRUCacheII.class
    );
  }
}