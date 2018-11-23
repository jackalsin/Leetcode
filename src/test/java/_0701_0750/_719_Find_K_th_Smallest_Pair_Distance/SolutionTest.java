package _0701_0750._719_Find_K_th_Smallest_Pair_Distance;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final int[] nums = {1, 3, 1};
    final int k = 1;
    assertEquals(0, solution.smallestDistancePair(nums, k));
  }

  @Test
  public void testOnlineCase2WithDupKEquals5() {
    final int[] nums = {1, 3, 1, 7};
    final int k = 5;
    assertEquals(6, solution.smallestDistancePair(nums, k));
  }

  @Test
  public void testOnlineCase2WithDupKEquals4() {
    final int[] nums = {1, 3, 1, 7};
    final int k = 4;
    assertEquals(4, solution.smallestDistancePair(nums, k));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final int[] input = {1, 1, 2, 4, 7, 11};
    int actual2 = solution.smallestDistancePair(input, 2);
    int actual7 = solution.smallestDistancePair(input, 7);
    assertEquals(1, actual2);
    assertEquals(3, actual7);
  }

  @Test
  public void testFailedCase1() throws Exception {
    final int[] nums = {9, 10, 7, 10, 6, 1, 5, 4, 9, 8};
    final int k = 18;
    Solution solution = new Solution();
    assertEquals(2, solution.smallestDistancePair(nums, k));
  }
}
