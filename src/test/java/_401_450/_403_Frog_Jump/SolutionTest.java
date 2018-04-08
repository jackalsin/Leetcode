package _401_450._403_Frog_Jump;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
//    solution = new SlowSolution();
    solution = new DfsSolution();
  }

  @Test
  void testOnlineCase1() {
    final int[] nums = {0};
    assertTrue(solution.canCross(nums));
  }

  @Test
  void testOnlineCase2() {
    final int[] nums = {0, 1, 3, 5, 6, 8, 12, 17};
    assertTrue(solution.canCross(nums));
  }

  @Test
  void testOnlineCase3() {
    final int[] nums = {0, 1, 2, 3, 4, 8, 9, 11};
    assertFalse(solution.canCross(nums));
  }

}