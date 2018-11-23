package _0201_0250._209_Minimum_Size_Subarray_Sum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 8/6/2017.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testEmpty() {
    assertEquals(0, solution.minSubArrayLen(1, new int[]{}));
  }

  @Test
  void testOnlineCase() {
    final int[] input = new int[]{2, 3, 1, 2, 4, 3};
    assertEquals(2, solution.minSubArrayLen(7, input));
  }

}
