package _451_500._457_Circular_Array_Loop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new MapSolution();
  }

  @Test
  void testOnlineCase1() {
    final int[] nums = {2, -1, 1, 2, 2};
    assertTrue(solution.circularArrayLoop(nums));
  }

  @Test
  void testOnlineCase2() {
    final int[] nums = {-1, 2};
    assertFalse(solution.circularArrayLoop(nums));
  }
}