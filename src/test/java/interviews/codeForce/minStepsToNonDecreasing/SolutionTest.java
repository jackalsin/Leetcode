package interviews.codeForce.minStepsToNonDecreasing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final int[] nums = {3, 1, 2, 1};
    assertEquals(1, solution.minStepsToNonIncreasing(nums));
  }

  @Test
  void testOnlineCase2() {
    final int[] nums = {3, 2, -1, 2, 11};
    assertEquals(4, solution.minStepsToNonDecreasing(nums));
  }

  @Test
  void testOnlineCase3() {
    final int[] nums = {2, 1, 1, 1, 1};
    assertEquals(1, solution.minStepsToNonDecreasing(nums));
  }

  @Test
  void testOnlineCase4() {
    final int[] nums = {2, 2, 1, 1, 1};
    assertEquals(2, solution.minStepsToNonDecreasing(nums));
  }

  @Test
  void testOnlineCase5() {
    final int[] nums = {1, 2, 5, 1};
    assertEquals(4, solution.minStepsToNonDecreasing(nums));
  }

}