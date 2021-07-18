package doordash._210_Course_Schedule_II;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 7/7/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testEmpty(Solution solution) {
    final int[][] courses = new int[][]{};
    final int numCourses = 0;
    assertArrayEquals(new int[0], solution.findOrder(numCourses, courses));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase(Solution solution) {
    final int[][] courses = new int[][]{
        {1, 0}, {2, 0}, {3, 1}, {3, 2}
    };
    final int numCourses = 4;

    int[] actual = solution.findOrder(numCourses, courses);
    if (!Arrays.equals(new int[]{0, 1, 2, 3}, actual) && !Arrays.equals(new int[]{0, 2, 1, 3},
        actual)) {
      Assertions.fail();
    }
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }
}