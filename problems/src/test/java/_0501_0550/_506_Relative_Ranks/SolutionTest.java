package _0501_0550._506_Relative_Ranks;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new TreeMapSolution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final int[] nums = {5, 4, 3, 2, 1};
    final String[] expected = {"Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"};
    assertArrayEquals(expected, solution.findRelativeRanks(nums));
  }

  @Test
  public void testEmpty() throws Exception {
    final int[] nums = {};
    final String[] expected = {};
    assertArrayEquals(expected, solution.findRelativeRanks(nums));
  }

  @Test
  public void testRank() {
    final int[] nums = {10, 3, 8, 9, 4};
    final String[] expected = {"Gold Medal", "5", "Bronze Medal", "Silver Medal", "4"};
    assertArrayEquals(expected, solution.findRelativeRanks(nums));
  }
}