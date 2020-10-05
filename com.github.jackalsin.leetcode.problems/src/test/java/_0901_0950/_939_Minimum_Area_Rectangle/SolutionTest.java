package _0901_0950._939_Minimum_Area_Rectangle;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  static Stream<Solution> solutionStream() {
    return Stream.of(
        new DiagonalSolution(),
        new OptimalSolution()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[][] input = {
        {1, 1}, {1, 3}, {3, 1}, {3, 3}, {2, 2}
    };
    assertEquals(4, solution.minAreaRect(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[][] input = {
        {1, 1}, {1, 3}, {3, 1}, {3, 3}, {4, 1}, {4, 3}
    };
    assertEquals(2, solution.minAreaRect(input));
  }
}