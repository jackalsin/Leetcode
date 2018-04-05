package _351_400._376_Wiggle_Subsequence;

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
    final int[] nums = {1, 7, 4, 9, 2, 5};
    assertEquals(6, solution.wiggleMaxLength(nums));
  }

  @Test
  void testOnlineCase2() {
    final int[] nums = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
    assertEquals(7, solution.wiggleMaxLength(nums));
  }

  @Test
  void testOnlineCase3() {
    final int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    assertEquals(2, solution.wiggleMaxLength(nums));
  }

  @Test
  void testEmpty() {
    final int[] nums = {};
    assertEquals(0, solution.wiggleMaxLength(nums));
  }
}