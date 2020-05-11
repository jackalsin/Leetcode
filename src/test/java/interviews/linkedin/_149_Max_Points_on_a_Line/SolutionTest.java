package interviews.linkedin._149_Max_Points_on_a_Line;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/20/2017.
 */
class SolutionTest {
  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCountSelf(Solution solution) {
    final int[][] points = {{0, 0}};
    assertEquals(1, solution.maxPoints(points));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testEmpty(Solution solution) {
    final int[][] points = {};
    assertEquals(0, solution.maxPoints(points));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCase(Solution solution) {
    final int[][] points = {{0, 0}, {1, 1}, {0, 0}};
    assertEquals(3, solution.maxPoints(points));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCase2(Solution solution) {
    //Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
    final int[][] points = {{1, 1}, {3, 2},
        {5, 3}, {4, 1}, {2, 3}, {1, 4}};
    assertEquals(4, solution.maxPoints(points));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new MapSolution()
    );
  }
}
