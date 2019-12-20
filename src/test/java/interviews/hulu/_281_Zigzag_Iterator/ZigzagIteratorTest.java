package interviews.hulu._281_Zigzag_Iterator;

import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author jacka
 * @version 1.0 on 12/18/2019
 */
class ZigzagIteratorTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase(Class<Solution> cacheClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    final List<Integer> v1 = Arrays.asList(1, 2);
    final List<Integer> v2 = Arrays.asList(3, 4, 5, 6);
    final Solution iterator = cacheClass.getConstructor(List.class, List.class).newInstance(v1, v2);
    final List<Integer> expected = Arrays.asList(1, 3, 2, 4, 5, 6);
    final List<Integer> actual = new ArrayList<>();

    while (iterator.hasNext()) {
      actual.add(iterator.next());
    }

    Assert.assertEquals(expected, actual);
  }

  static Stream<Class> solutionProvider() {
    return Stream.of(
        ZigzagIterator.class
    );
  }
}