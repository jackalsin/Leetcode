package _1051_1100._1091_Shortest_Path_in_Binary_Matrix;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 11/27/2019
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int[][] input = {
        {0, 0, 0},
        {1, 1, 0},
        {1, 1, 0}};
    assertEquals(4, solution.shortestPathBinaryMatrix(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final int[][] input = {{0, 1}, {1, 0}};
    assertEquals(2, solution.shortestPathBinaryMatrix(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final int[][] input = {{0}};
    assertEquals(1, solution.shortestPathBinaryMatrix(input));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new BfsSolution()
    );
  }
}