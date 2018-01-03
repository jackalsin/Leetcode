package _701_750._719_Find_K_th_Smallest_Pair_Distance;

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
}