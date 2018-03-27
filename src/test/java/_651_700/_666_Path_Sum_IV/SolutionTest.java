package _651_700._666_Path_Sum_IV;

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
    final int[] input = {113, 215, 221};
    assertEquals(12, solution.pathSum(input));
  }

  @Test
  void testOnlineCase2() {
    final int[] input = {113, 221};
    assertEquals(4, solution.pathSum(input));
  }

  @Test
  void testFailedCase1() {
    final int[] input = {113, 229, 349, 470, 485};
    assertEquals(47, solution.pathSum(input));
  }
}