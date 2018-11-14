package _701_750._724_Find_Pivot_Index;

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
    final int[] nums = {1, 7, 3, 6, 5, 6};
    assertEquals(3, solution.pivotIndex(nums));
  }

  @Test
  void testOnlineCase2() {
    final int[] nums = {1, 2, 3};
    assertEquals(-1, solution.pivotIndex(nums));
  }
}