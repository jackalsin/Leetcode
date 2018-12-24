package _0801_0850._827_Making_A_Large_Island;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DfsSolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new DfsSolution();
  }

  @Test
  void testOnlineCase1() {
    final int[][] input = {
        {1, 0}, {0, 1}
    };
    assertEquals(3, solution.largestIsland(input));
  }

  @Test
  void testOnlineCase3() {
    final int[][] input = {
        {1, 1},
        {1, 0}
    };
    assertEquals(4, solution.largestIsland(input));
  }

  @Test
  void testOnlineCase2() {
    final int[][] input = {
        {1, 1}, {1, 1}
    };
    assertEquals(4, solution.largestIsland(input));
  }
}