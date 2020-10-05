package _0651_0700._673_Number_of_Longest_Increasing_Subsequence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
//    solution = new MySolution();
//    solution = new SegmentTreeSolutionRef();
    solution = new SegmentTreeSolution();
  }

  @Test
  void testOnlineCase1() {
    // 1, 3, 5, 7
    // 1, 3, 4, 7
    final int[] nums = {1, 3, 5, 4, 7};
    assertEquals(2, solution.findNumberOfLIS(nums));
  }

  @Test
  void testOnlineCase2() {
    final int[] nums = {2, 2, 2, 2, 2};
    assertEquals(5, solution.findNumberOfLIS(nums));
  }

  @Test
  void testOnlineCase3() {
    // 1, 2, 4, 5, 7
    // 1, 2, 3, 5, 7
    // 1, 2, 3, 4, 7
    final int[] nums = {1, 2, 4, 3, 5, 4, 7, 2};
    assertEquals(3, solution.findNumberOfLIS(nums));
  }

  @Test
  void testOnlineCase4() {
    // 1, 2, 4
    // 1, 2, 3
    final int[] nums = {1, 2, 4, 3};
    assertEquals(2, solution.findNumberOfLIS(nums));
  }
}