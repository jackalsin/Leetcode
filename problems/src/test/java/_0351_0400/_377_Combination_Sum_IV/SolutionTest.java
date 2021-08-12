package _0351_0400._377_Combination_Sum_IV;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 11/8/2017.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() throws Exception {
    final int[] nums = new int[]{1, 2, 3};
    assertEquals(7, solution.combinationSum4(nums, 4));
  }

  @Test
  void testEmpty() throws Exception {
    final int[] nums = new int[]{};
    assertEquals(1, solution.combinationSum4(nums, 0));
  }

  @Test
  void testEmptyAnd1() throws Exception {
    final int[] nums = new int[]{};
    assertEquals(0, solution.combinationSum4(nums, 1));
  }

}
