package _0901_0950._934_Shortest_Bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BfsSolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new BfsSolution();
  }

  @Test
  void testOnlineCase1() {
    final int[][] input = {
        {0, 1}, {1, 0}
    };
    assertEquals(1, solution.shortestBridge(input));
  }

  @Test
  void testOnlineCase2() {
    final int[][] input = {
        {0, 1, 0},
        {0, 0, 0},
        {0, 0, 1}
    };
    assertEquals(2, solution.shortestBridge(input));
  }

  @Test
  void testOnlineCase3() {
    final int[][] input = {
        {1, 1, 1, 1, 1},
        {1, 0, 0, 0, 1},
        {1, 0, 1, 0, 1},
        {1, 0, 0, 0, 1},
        {1, 1, 1, 1, 1}

    };
    assertEquals(1, solution.shortestBridge(input));
  }

  @Test
  void testFailedCase1() {
    final int[][] input = {
        {0, 0, 0, 1, 0, 0, 0, 1},
        {0, 0, 0, 1, 1, 0, 1, 1}, // (1, 6)
        {0, 1, 1, 1, 0, 0, 1, 1},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0}
    };
    assertEquals(1, solution.shortestBridge(input));
  }
}