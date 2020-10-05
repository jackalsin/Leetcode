package airbnb._773_Sliding_Puzzle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/16/2019.
 */
class SolutionTest {

  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final int[][] board = {
        {1, 2, 3},
        {4, 0, 5}
    };
    assertEquals(1, solution.slidingPuzzle(board));
  }

  @Test
  void testOnlineCase2() {
    final int[][] board = {
        {1, 2, 3},
        {5, 4, 0}
    };
    assertEquals(-1, solution.slidingPuzzle(board));
  }

  @Test
  void testOnlineCase3() {
    final int[][] board = {
        {4, 1, 2},
        {5, 0, 3}
    };
    assertEquals(5, solution.slidingPuzzle(board));
  }

  @Test
  void testOnlineCase4() {
    final int[][] board = {
        {3, 2, 4},
        {1, 5, 0}
    };
    assertEquals(14, solution.slidingPuzzle(board));
  }
}