package airbnb._251_Flatten_2D_Vector;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/28/2019.
 */
class Vector2DTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnline(Class<Vector2D> solutionClass) throws NoSuchMethodException, InvocationTargetException,
      InstantiationException, IllegalAccessException {
    final int[][] input = new int[][]{
        {1, 2},
        {},
        {3},
        {4, 5, 6}
    };
    Vector2D vector2D = solutionClass.getConstructor(int[][].class).newInstance((Object) input);
    final List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
    final List<Integer> actual = new ArrayList<>();
    while (vector2D.hasNext()) {
      actual.add(vector2D.next());
    }

    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testEmpty(Class<Vector2D> solutionClass) throws NoSuchMethodException, InvocationTargetException,
      InstantiationException, IllegalAccessException {
    final int[][] input = new int[][]{};
    Vector2D vector2D = solutionClass.getConstructor(int[][].class).newInstance((Object) input);
    final List<Integer> expected = Collections.emptyList();
    final List<Integer> actual = new ArrayList<>();
    while (vector2D.hasNext()) {
      actual.add(vector2D.next());
    }

    assertEquals(expected, actual);
  }

  static Stream<Class> solutionStream() {
    return Stream.of(
        Vector2DI.class,
        Vector2DII.class
    );
  }
}