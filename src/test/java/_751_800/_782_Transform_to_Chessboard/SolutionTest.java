package _751_800._782_Transform_to_Chessboard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/8/2018.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new Solution();
  }

  @Test
  void testCaseOnlineCase() {
    final int[][] board = {
        {0, 1, 1, 0},
        {0, 1, 1, 0},
        {1, 0, 0, 1},
        {1, 0, 0, 1}
    };

    assertEquals(2, solution.movesToChessboard(board));
  }

  @Test
  void testCaseOnlineCase2() {
    final int[][] board = {
        {1, 0},
        {1, 0}
    };

    assertEquals(-1, solution.movesToChessboard(board));
  }
}
