package _0451_0500._499_The_Maze_III;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new DfsSolution(),
        new BfsSolution()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[][] board = {
        {0, 0, 0, 0, 0},
        {1, 1, 0, 0, 1},
        {0, 0, 0, 0, 0},
        {0, 1, 0, 0, 1},
        {0, 1, 0, 0, 0},
    };
    assertEquals("lul", solution.findShortestWay(board, new int[]{4, 3}, new int[]{0, 1}));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[][] board = {
        {0, 0, 0, 0, 0},
        {1, 1, 0, 0, 1},
        {0, 0, 0, 0, 0},
        {0, 1, 0, 0, 1},
        {0, 1, 0, 0, 0}
    };
    assertEquals("impossible", solution.findShortestWay(board, new int[]{4, 3}, new int[]{3, 0}));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCase1(Solution solution) {
    final int[][] board = {
        {0, 0, 1, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 1, 0},
        {1, 1, 0, 1, 1},
        {0, 0, 0, 0, 0}
    };
    assertEquals("ldldrdr", solution.findShortestWay(board, new int[]{0, 4}, new int[]{4, 4}));
  }
}