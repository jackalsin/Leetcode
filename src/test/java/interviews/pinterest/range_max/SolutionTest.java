package interviews.pinterest.range_max;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  @Test
  void testOnlineCase1() {
    final int[] nums = {1, 3, 4, 5, 7};
    final Solution solution = new Solution(nums);
    assertEquals(7, solution.query(0, 4));
  }

  @Test
  void testOnlineCase2() {
    final int[] nums = {1, 3, 4, 5, 7};
    final Solution solution = new Solution(nums);
    assertEquals(3, solution.query(0, 1));
  }

  @Test
  void testOnlineCase3() {
    final int[] nums = {1, 3, 4, 5, 7};
    final Solution solution = new Solution(nums);
    assertEquals(5, solution.query(2, 3));
  }

  @Test
  void testOnlineCase4() {
    final int[] nums = {1, 3, 4, 5, 7};
    final Solution solution = new Solution(nums);
    assertEquals(1, solution.query(0, 0));
  }
}