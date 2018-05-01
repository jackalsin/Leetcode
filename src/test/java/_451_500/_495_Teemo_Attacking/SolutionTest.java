package _451_500._495_Teemo_Attacking;

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
    final int[] nums = {1, 4};
    assertEquals(4, solution.findPoisonedDuration(nums, 2));
  }

  @Test
  void testOnlineCase2() {
    final int[] nums = {1, 2};
    assertEquals(3, solution.findPoisonedDuration(nums, 2));
  }
}