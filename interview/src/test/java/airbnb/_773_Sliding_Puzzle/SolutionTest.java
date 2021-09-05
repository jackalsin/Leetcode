package airbnb._773_Sliding_Puzzle;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/16/2019.
 */
class SolutionTest {

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new MNSolution(),
        new SolutionII()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[][] board = {
        {1, 2, 3},
        {4, 0, 5}
    };
    assertEquals(1, solution.slidingPuzzle(board));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[][] board = {
        {1, 2, 3},
        {5, 4, 0}
    };
    assertEquals(-1, solution.slidingPuzzle(board));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int[][] board = {
        {4, 1, 2},
        {5, 0, 3}
    };
    assertEquals(5, solution.slidingPuzzle(board));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final int[][] board = {
        {3, 2, 4},
        {1, 5, 0}
    };
    assertEquals(14, solution.slidingPuzzle(board));
  }
}