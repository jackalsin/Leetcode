package _601_650._644_Maximum_Average_Subarray_II;

import org.junit.Before;
import org.junit.Test;

/**
 * @author jacka
 * @version 1.0 on 12/26/2017.
 */
public class ONSolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new ONSolution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    // 0, 1, 2, 3, 4,   5, 6,  7, 8, 9, 10
    final int[] nums = {1, 7, 8, 12, 17, 22, 50, 8, 9, 10, 11};
    final int k = 4;
    solution.findMaxAverage(nums, k);
  }

  @Test
  public void testOnlineCase2() throws Exception {
    // 0, 1, 2, 3, 4,   5, 6,  7, 8, 9, 10
    final int[] nums = {20, 7, 8, 12, 17, 22, 50, 8, 9, 10, 11};
    final int k = 4;
    solution.findMaxAverage(nums, k);
  }

  @Test
  public void testDecreasing() throws Exception {
    // 0,  1,  2, 3,  4,
    final int[] nums = {20, 16, 14, 12, 8};
    final int k = 3;
    solution.findMaxAverage(nums, k);
  }
}
