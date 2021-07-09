package doordash._1129_Shortest_Path_with_Alternating_Colors;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 7/8/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int n = 3, red_edges[][] = {{0, 1}, {1, 2}},
        blue_edges[][] = {};
    final int[] expected = {0, 1, -1}, actual = solution.shortestAlternatingPaths(n, red_edges, blue_edges);
    assertArrayEquals(expected, actual, Arrays.toString(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int n = 3, red_edges[][] = {{0, 1}, {1, 2}},
        blue_edges[][] = {{2, 1}};
    final int[] expected = {0, 1, -1}, actual = solution.shortestAlternatingPaths(n, red_edges, blue_edges);
    assertArrayEquals(expected, actual, Arrays.toString(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int n = 3, red_edges[][] = {{0, 1}},
        blue_edges[][] = {{1, 2}};
    final int[] expected = {0, 1, 2}, actual = solution.shortestAlternatingPaths(n, red_edges, blue_edges);
    assertArrayEquals(expected, actual, Arrays.toString(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final int n = 3, red_edges[][] = {{0, 1}, {0, 2}},
        blue_edges[][] = {{1, 0}};
    final int[] expected = {0, 1, 1}, actual = solution.shortestAlternatingPaths(n, red_edges, blue_edges);
    assertArrayEquals(expected, actual, Arrays.toString(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase5(Solution solution) {
    final int n = 5, red_edges[][] = {{0, 1}, {1, 2}, {2, 3}, {3, 4}},
        blue_edges[][] = {{1, 2}, {2, 3}, {3, 1}};
    final int[] expected = {0, 1, 2, 3, 7}, actual = solution.shortestAlternatingPaths(n, red_edges, blue_edges);
    assertArrayEquals(expected, actual, Arrays.toString(actual));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new DpSolution()
    );
  }
}