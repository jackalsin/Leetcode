package interviews.microsoft.noodleEssence._659_Split_Array_into_Consecutive_Subsequences;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final int[] nums = {1, 2, 3, 4, 5, 6};
    assertTrue(solution.isPossible(nums));
  }

  @Test
  void testOnlineCase2() {
    final int[] nums = {1, 2, 3, 3, 4, 4, 5, 5};
    assertTrue(solution.isPossible(nums));
  }

  @Test
  void testOnlineCase3() {
    final int[] nums = {1, 2, 3, 4, 4, 6};
    assertFalse(solution.isPossible(nums));
  }

}