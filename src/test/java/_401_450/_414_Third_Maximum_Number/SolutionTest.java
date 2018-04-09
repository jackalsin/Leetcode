package _401_450._414_Third_Maximum_Number;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final int[] nums = {3, 2, 1};
    assertEquals(1, solution.thirdMax(nums));
  }

  @Test
  void testOnlineCase2() {
    final int[] nums = {1, 2};
    assertEquals(2, solution.thirdMax(nums));
  }

  @Test
  void testOnlineCase3() {
    final int[] nums = {2, 2, 3, 1};
    assertEquals(1, solution.thirdMax(nums));
  }
}