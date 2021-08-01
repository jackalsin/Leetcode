package doordash._986_Interval_List_Intersections;

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
  void testOnlineCase1(Solution solution) {
    final int[][] A = {{0, 2}, {5, 10}, {13, 23}, {24, 25}},
        B = {{1, 5}, {8, 12}, {15, 24}, {25, 26}},
        expected = {{1, 2}, {5, 5}, {8, 10}, {15, 23}, {24, 24}, {25, 25}},
        actual = solution.intervalIntersection(A, B);
    assertArrayEquals(expected, actual, Arrays.deepToString(actual));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }
}