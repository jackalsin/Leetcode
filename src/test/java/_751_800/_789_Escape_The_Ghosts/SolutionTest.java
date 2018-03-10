package _751_800._789_Escape_The_Ghosts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 3/9/2018.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new Solution();
  }

  @Test
  void testCase1() {
    final int[][] ghosts = {{1, 0}, {0, 3}};
    final int[] target = {0, 1};
    assertTrue(solution.escapeGhosts(ghosts, target));
  }

  @Test
  void testCase2() {
    final int[][] ghosts = {{1, 0}};
    final int[] target = {2, 0};
    assertFalse(solution.escapeGhosts(ghosts, target));
  }

  @Test
  void testCase3() {
    final int[][] ghosts = {{2, 0}};
    final int[] target = {1, 0};
    assertFalse(solution.escapeGhosts(ghosts, target));
  }

  @Test
  void testNegativeCoordinate() {
    final int[][] ghosts = {{1, 9}, {2, -5}, {3, 8}, {9, 8}, {-1, 3}};
    final int[] target = {8, -10};
    assertFalse(solution.escapeGhosts(ghosts, target));
  }
}
