package interviews.tableau._218_The_Skyline_Problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/15/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testFailedCase(Solution solution) {
    final int[][] input = new int[][]{{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
    final List<List<Integer>> expected = List.of(List.of(2, 10), List.of(3, 15), List.of(7, 12),
        List.of(12, 0), List.of(15, 10), List.of(20, 8), List.of(24, 0)), actual = solution.getSkyline(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testFailedTestCase(Solution solution) {
    final int[][] input = new int[][]{{0, 3, 3}, {1, 5, 3}, {2, 4, 3}, {3, 7, 3}};
    final List<List<Integer>> expected = List.of(
        List.of(0, 3), List.of(7, 0)), actual = solution.getSkyline(input);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}