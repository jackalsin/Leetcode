package byteDance._329_Longest_Increasing_Path_in_a_Matrix;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/8/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase(Solution solution) {
    final int[][] board = {
        {9, 9, 4},
        {6, 6, 8},
        {2, 1, 1},
    };
    assertEquals(4, solution.longestIncreasingPath(board));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase2(Solution solution) {
    final int[][] board = {
        {3, 4, 5},
        {3, 2, 6},
        {2, 2, 1},
    };
    assertEquals(4, solution.longestIncreasingPath(board));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase3(Solution solution) {
    final int[][] board = {
        {1, 2},
    };
    assertEquals(2, solution.longestIncreasingPath(board));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase4(Solution solution) {
    final int[][] board = {
        {0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
        {19, 18, 17, 16, 15, 14, 13, 12, 11, 10},
        {20, 21, 22, 23, 24, 25, 26, 27, 28, 29},
        {39, 38, 37, 36, 35, 34, 33, 32, 31, 30},
        {40, 41, 42, 43, 44, 45, 46, 47, 48, 49},
        {59, 58, 57, 56, 55, 54, 53, 52, 51, 50},
        {60, 61, 62, 63, 64, 65, 66, 67, 68, 69},
        {79, 78, 77, 76, 75, 74, 73, 72, 71, 70},
        {80, 81, 82, 83, 84, 85, 86, 87, 88, 89},
        {99, 98, 97, 96, 95, 94, 93, 92, 91, 90},
        {100, 101, 102, 103, 104, 105, 106, 107, 108, 109},
        {119, 118, 117, 116, 115, 114, 113, 112, 111, 110},
        {120, 121, 122, 123, 124, 125, 126, 127, 128, 129},
        {139, 138, 137, 136, 135, 134, 133, 132, 131, 130},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    };
    assertEquals(140, solution.longestIncreasingPath(board));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }
}