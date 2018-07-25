package _801_850._801_Minimum_Swaps_To_Make_Sequences_Increasing;

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
    final int[] A = {1, 3, 5, 4}, B = {1, 2, 3, 7};
    assertEquals(1, solution.minSwap(A, B));
  }

  @Test
  void testOnlineCase2() {
    final int[] A = {1, 3, 5, 4, 5, 6},
        B = {1, 2, 3, 7, 8, 9};
    assertEquals(2, solution.minSwap(A, B));
  }
}