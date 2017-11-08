package _351_400._377_Combination_Sum_IV;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author jacka
 * @version 1.0 on 11/8/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final int[] nums = new int[] {1, 2, 3};
    assertEquals(7, solution.combinationSum4(nums, 4));
  }

  @Test
  public void testEmpty() throws Exception {
    final int[] nums = new int[] {};
    assertEquals(1, solution.combinationSum4(nums, 0));
  }

  @Test
  public void testEmptyAnd1() throws Exception {
    final int[] nums = new int[] {};
    assertEquals(0, solution.combinationSum4(nums, 1));
  }

}
