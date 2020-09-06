package _0801_0850._847_Shortest_Path_Visiting_All_Nodes;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/5/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[][] input = {
        {1, 2, 3},
        {0},
        {0},
        {0}};
    assertEquals(4, solution.shortestPathLength(input));
//    One possible path is[ 1, 0, 2, 0, 3]
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[][] input = {
        {1},
        {0, 2, 4},
        {1, 3, 4},
        {2},
        {1, 2}};
    assertEquals(4, solution.shortestPathLength(input));
//    One possible path is[ 0, 1, 4, 2, 3]
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}