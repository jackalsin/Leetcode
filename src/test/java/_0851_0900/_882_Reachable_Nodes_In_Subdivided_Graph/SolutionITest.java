package _0851_0900._882_Reachable_Nodes_In_Subdivided_Graph;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/14/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int edges[][] = {{0, 1, 10}, {0, 2, 1}, {1, 2, 2}},
        M = 6, N = 3, expected = 13, actual = solution.reachableNodes(edges, M, N);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int edges[][] = {
        {0, 1, 4}, {1, 2, 6}, {0, 2, 8}, {1, 3, 1}
    }, M = 10, N = 4, expected = 23, actual = solution.reachableNodes(edges, M, N);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int edges[][] = {
        {3, 4, 8},
        {0, 1, 3},
        {1, 4, 0},
        {1, 2, 3},
        {0, 3, 2},
        {0, 4, 10},
        {1, 3, 3},
        {2, 4, 3},
        {2, 3, 3},
        {0, 2, 10}},
        M = 7, N = 5, expected = 43, actual = solution.reachableNodes(edges, M, N);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final int edges[][] = {
        {1, 2, 4},
        {1, 4, 5},
        {1, 3, 1},
        {2, 3, 4},
        {3, 4, 5}
    }, M = 17, N = 5, expected = 1, actual = solution.reachableNodes(edges, M, N);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}