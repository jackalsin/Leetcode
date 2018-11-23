package _0451_0500._473_Matchsticks_to_Square;

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
    final int[] input = {1, 1, 2, 2, 2};
    assertTrue(solution.makesquare(input));
  }

  @Test
  void testOnlineCase2() {
    final int[] input = {3, 3, 3, 3, 4};
    assertFalse(solution.makesquare(input));
  }

  @Test
  void testFailedOnTLE() {
    final int[] input = {10, 6, 5, 5, 5, 3, 3, 3, 2, 2, 2, 2};
    assertTrue(solution.makesquare(input));
  }

  @Test
  void testFailedCase2() {
    final int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    assertTrue(solution.makesquare(input));
  }
}