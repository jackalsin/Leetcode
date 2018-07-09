package interviews.microsoft._189_Rotate_Array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final int[] nums = {1, 2, 3, 4, 5, 6, 7};
    final int[] expected = {5, 6, 7, 1, 2, 3, 4};
    solution.rotate(nums, 3);
    assertArrayEquals(expected, nums);
  }
}