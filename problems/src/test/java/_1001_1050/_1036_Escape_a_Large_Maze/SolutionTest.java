package _1001_1050._1036_Escape_a_Large_Maze;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final int[][] blocked = {{0, 1}, {1, 0}};
    final int[] source = {0, 0};
    final int[] target = {0, 2};
    assertFalse(solution.isEscapePossible(blocked, source, target));
  }

  @Test
  void testOnlineCase2() {
    final int[][] blocked = {};
    final int[] source = {0, 0};
    final int[] target = {999999, 999999};
    assertTrue(solution.isEscapePossible(blocked, source, target));
  }
}