package _0401_0450._446_Arithmetic_Slices_II_Subsequence;

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
    final int[] nums = {2, 4, 6, 8, 10};
    assertEquals(7, solution.numberOfArithmeticSlices(nums));
  }
}