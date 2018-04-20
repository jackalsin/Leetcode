package _451_500._454_4Sum_II;

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
    final int[] A = {1, 2};
    final int[] B = {-2, -1};
    final int[] C = {-1, 2};
    final int[] D = {0, 2};
    assertEquals(2, solution.fourSumCount(A, B, C, D));
  }

}