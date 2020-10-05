package microsoft.noodleEssence._081_Search_in_Rotated_Sorted_Array_II;

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
    final int nums[] = {2, 5, 6, 0, 0, 1, 2}, target = 0;
    assertTrue(solution.search(nums, target));
  }

  @Test
  void testOnlineCase2() {
    final int nums[] = {2, 5, 6, 0, 0, 1, 2}, target = 3;
    assertFalse(solution.search(nums, target));
  }

  @Test
  void testFailedCase1() {
    final int nums[] = {3, 1}, target = 1;
    assertTrue(solution.search(nums, target));
  }

  @Test
  void testFailedCase2() {
    final int nums[] = {1}, target = 0;
    assertFalse(solution.search(nums, target));
  }

  @Test
  void testFailedCase3() {
    final int nums[] = {1, 2, 1}, target = 1;
    assertTrue(solution.search(nums, target));
  }

  @Test
  void testFailedCase4() {
    final int nums[] = {2, 5, 6, 0, 0, 1, 2}, target = 0;
    assertTrue(solution.search(nums, target));
  }
}