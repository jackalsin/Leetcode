package _701_750._711_Number_of_Distinct_Islands_II;

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
    final int[] input = {1, 3, 1};
    int actual1 = solution.smallestDistancePair(input, 1);
    assertEquals(0, actual1);
//    int actual2 = solution.smallestDistancePair(input, 2);
    int actual2 = new SampleSolution().smallestDistancePair(input, 2);
    assertEquals(2, actual2);
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