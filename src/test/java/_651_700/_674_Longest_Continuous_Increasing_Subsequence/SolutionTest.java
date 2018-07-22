package _651_700._674_Longest_Continuous_Increasing_Subsequence;

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
    final int[] nums = {1, 3, 5, 4, 7};
    assertEquals(3, solution.findLengthOfLCIS(nums));
  }

  @Test
  void testOnlineCase2() {
    final int[] nums = {2, 2, 2, 2, 2};
    assertEquals(1, solution.findLengthOfLCIS(nums));
  }
}