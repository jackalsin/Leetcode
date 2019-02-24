package _1001_1050._1001_Grid_Illumination;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 2/23/2019.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final int N = 5;
    final int[][] lamps = {{0, 0}, {4, 4}};
    final int[][] queries = {{1, 1}, {1, 0}};
    final int[] expected = {1, 0};
    assertArrayEquals(expected, solution.gridIllumination(N, lamps, queries));
  }

  @Test
  void testOnlineCase2() {
    final int N = 10;
    final int[][] lamps = {
        {3, 4}, {6, 6}, {1, 8}, {4, 5}, {8, 7}, {0, 6}, {5, 2}, {1, 9}
    };
    final int[][] queries = {
        {7, 9}, {2, 8}, {8, 6}, {6, 8}, {2, 8}
    };
    final int[] expected = {1, 1, 1, 1, 1};
    assertArrayEquals(expected, solution.gridIllumination(N, lamps, queries));
  }
}