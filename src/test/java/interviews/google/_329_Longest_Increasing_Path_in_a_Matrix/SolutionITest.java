package interviews.google._329_Longest_Increasing_Path_in_a_Matrix;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/21/2020
 */
class SolutionITest {


  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testOnlineCase(Solution solution) {
    final int[][] board = {
        {9, 9, 4},
        {6, 6, 8},
        {2, 1, 1},
    };
    assertEquals(4, solution.longestIncreasingPath(board));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testOnlineCase2(Solution solution) {
    final int[][] board = {
        {3, 4, 5},
        {3, 2, 6},
        {2, 2, 1},
    };
    assertEquals(4, solution.longestIncreasingPath(board));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}