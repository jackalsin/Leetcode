package _451_500._499_The_Maze_III;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final int[][] board = {
        {0, 0, 0, 0, 0},
        {1, 1, 0, 0, 1},
        {0, 0, 0, 0, 0},
        {0, 1, 0, 0, 1},
        {0, 1, 0, 0, 0},
    };
    assertEquals("lul", solution.findShortestWay(board, new int[]{4, 3}, new int[]{0, 1}));
  }

  /**
   *
   */
  @Test
  void testOnlineCase2() {
    final int[][] board = {
        {0, 0, 0, 0, 0},
        {1, 1, 0, 0, 1},
        {0, 0, 0, 0, 0},
        {0, 1, 0, 0, 1},
        {0, 1, 0, 0, 0}
    };
    assertEquals("impossible", solution.findShortestWay(board, new int[]{4, 3}, new int[]{3, 0}));
  }

  @Test
  void testFailedCase1() {
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