package doordash.shortestPath;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 7/1/2021
 */
class SolutionTest {

  /**
   *     1  - 1000 - 1001 - 1002 - 1003 - 1004
   * /   |  \                               |
   * 5   4   8                              |
   * \  |  /                                |
   *    6  ------------------------------- 1005 - 1006
   *
   * @param solution
   */
  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final List<Edge> input = List.of(
        Edge.of(1, 5),
        Edge.of(6, 5),
        Edge.of(1, 4),
        Edge.of(4, 6),
        Edge.of(1, 8),
        Edge.of(8, 6),
        Edge.of(1, 1000),
        Edge.of(1000, 1001),
        Edge.of(1001, 1002),
        Edge.of(1002, 1003),
        Edge.of(1003, 1004),
        Edge.of(1004, 1005),
        Edge.of(1005, 1006),
        Edge.of(1005, 6)
    );
    final Set<Edge> expected = Set.of(
        Edge.of(1, 5),
        Edge.of(6, 5),
        Edge.of(1, 4),
        Edge.of(4, 6),
        Edge.of(1, 8),
        Edge.of(6, 8)
    ), actual = solution.shortestPathEdges(input, 1, 6);

    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new BruteForceSolution()
    );
  }
}