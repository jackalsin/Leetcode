package airbnb._377_Combination_Sum_IV;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/19/2019.
 */
class TopDownSolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new TopDownSolution();
  }

  @Test
  void testOnlineCase1() {
    final int[] nums = new int[]{1, 2, 3};
    assertEquals(7, solution.combinationSum4(nums, 4));
  }

  @Test
  void testEmpty() {
    final int[] nums = new int[]{};
    assertEquals(1, solution.combinationSum4(nums, 0));
  }

  @Test
  void testEmptyAnd1() {
    final int[] nums = new int[]{};
    assertEquals(0, solution.combinationSum4(nums, 1));
  }

  @Test
  void testTLE() {
    final int[] nums = new int[]{3, 33, 333};
    assertEquals(0, solution.combinationSum4(nums, 10000));
  }
}