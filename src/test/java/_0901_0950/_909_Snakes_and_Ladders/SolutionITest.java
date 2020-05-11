package _0901_0950._909_Snakes_and_Ladders;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 12/15/2019
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[][] input = {
        {-1, -1, -1, -1, -1, -1},
        {-1, -1, -1, -1, -1, -1},
        {-1, -1, -1, -1, -1, -1},
        {-1, 35, -1, -1, 13, -1},
        {-1, -1, -1, -1, -1, -1},
        {-1, 15, -1, -1, -1, -1}
    };
    assertEquals(4, solution.snakesAndLadders(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCase1(Solution solution) {
    final int[][] input = {
        {-1, -1, -1},
        {-1, 9, 8},
        {-1, 8, 9}
    };
    assertEquals(1, solution.snakesAndLadders(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCase2(Solution solution) {
    final int[][] input = {
        //{43,44,45, 46, 47, 48, 49},
        {-1, -1, -1, -1, 48, 5, -1},
        //{42,41,40,39, 38, 37,36},
        {12, 29, 13, 9, -1, 2, 32},
        //{29,30,31,32, 33, 34, 35},
        {-1, -1, 21, 7, -1, 12, 49},
        //{28,27,26, 25, 24, 23, 22},
        {42, 37, 21, 40, -1, 22, 12},
        //{15,16,17,18, 19, 20, 21},
        {42, -1, 2, -1, -1, -1, 6},
        //{14, 13, 12, 11, 10, 9, 8},
        {39, -1, 35, -1, -1, 39, -1},
        // {1, 2, 3,  4,  5,  6, 7},
        {-1, 36, -1, -1, -1, -1, 5}
    };
    //  0,0 =>
    assertEquals(3, solution.snakesAndLadders(input));
  }

  @Test
  public void testGetIndex() {
    final int[][] board = {
        {36, 35, 34, 33, 32, 31},
        {25, 26, 27, 28, 29, 30},
        {24, 23, 22, 21, 20, 19},
        {13, 14, 15, 16, 17, 18},
        {12, 11, 10, 9, 8, 7},
        {1, 2, 3, 4, 5, 6},
    };
    for (int row = 0; row < 6; row++) {
      for (int col = 0; col < 6; col++) {
        final int val = board[row][col];
        final int[] rc = SolutionI.getIndex(6, 6, val);
        assertEquals(board[row][col], board[rc[0]][rc[1]], String.format("row  = %d, col = %d", row, col));
      }
    }
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}