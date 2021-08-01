package doordash.shortestPath;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 7/11/2021
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[][] edges = {
        {1, 2, 1},  // true
        {2, 3, 1},  // true
        {3, 4, 1},
        {4, 5, 1},
        {5, 1, 3},  // true
        {1, 3, 2},  // true
        {5, 3, 1},  // true
    };
    final boolean[] expected = {true, true, false, false, true, true, true},
        actual = solution.isOnShortestPath(edges, 1, 5);
    assertArrayEquals(expected, actual, Arrays.toString(actual));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new SolutionIII()
    );
  }
}