package _501_550._517_Super_Washing_Machines;

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
    final int[] nums = {1, 0, 5};
    assertEquals(3, solution.findMinMoves(nums));
  }

  @Test
  void testOnlineCase2() {
    final int[] nums = {0, 3, 0};
    assertEquals(2, solution.findMinMoves(nums));
  }

  @Test
  void testOnlineCase3() {
    final int[] nums = {0, 2, 0};
    assertEquals(-1, solution.findMinMoves(nums));
  }

  /**
   * Failed on abs(cur)
   */
  @Test
  void testFailedCase1() {
    final int[] nums = {9, 1, 8, 8, 9};
    assertEquals(4, solution.findMinMoves(nums));
  }
}