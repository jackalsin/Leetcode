package interviews.google._158_Read_N_Characters_Given_Read4_II_Call_multiple_times;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author jacka
 * @version 1.0 on 4/14/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase(Class<Solution> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    final String s = "abc";
    Solution solution = solutionClass.getConstructor(String.class).newInstance(s);
    assertEquals(1, solution.read(new char[1], 1));
    assertEquals(2, solution.read(new char[4], 4));
    assertEquals(0, solution.read(new char[0], 0));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Class<Solution> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    final String s = "abc";
    Solution solution = solutionClass.getConstructor(String.class).newInstance(s);
    assertEquals(1, solution.read(new char[1], 1));
    final char[] buffer = new char[2];
    assertEquals(2, solution.read(buffer, 2));
    assertArrayEquals(new char[]{'b', 'c'}, buffer);
    assertEquals(0, solution.read(new char[0], 0));
  }

  static Stream<Class> solutionStream() {
    return Stream.of(
        SolutionI.class
    );
  }
}