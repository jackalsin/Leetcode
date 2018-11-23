package _0451_0500._456_132_Pattern;

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
    final int[] nums = {1, 2, 3, 4};
    assertFalse(solution.find132pattern(nums));
  }

  @Test
  void testOnlineCase2() {
    final int[] nums = {3, 1, 4, 2};
    assertTrue(solution.find132pattern(nums));

  }

  @Test
  void testOnlineCase3() {
    final int[] nums = {-1, 3, 2, 0};
    assertTrue(solution.find132pattern(nums));
  }

  @Test
  void testFailedCase1() {
    final int[] nums = {1, 0, 1, -4, -3};
    assertFalse(solution.find132pattern(nums));
  }
}