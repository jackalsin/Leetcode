package _0851_0900._896_Monotonic_Array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    assertTrue(solution.isMonotonic(new int[]{1, 2, 2, 3}));
    assertTrue(solution.isMonotonic(new int[]{6, 5, 4, 4}));
    assertTrue(solution.isMonotonic(new int[]{1, 2, 4, 5}));
    assertTrue(solution.isMonotonic(new int[]{1, 1, 1}));
    assertFalse(solution.isMonotonic(new int[]{1, 3, 2}));
  }

}