package _0151_0200._158_Read_N_Characters_Given_Read4_II_Call_multiple_times;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 7/23/2017.
 */
public class SolutionTest {

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

  static Stream<Class> solutionStream() {
    return Stream.of(
        Solution.class
    );
  }
}
