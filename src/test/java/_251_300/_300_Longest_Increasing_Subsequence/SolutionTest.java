package _251_300._300_Longest_Increasing_Subsequence;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author jacka
 * @version 1.0 on 9/10/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase() throws Exception {
    final int[] input = {10, 9, 2, 5, 3, 7, 101, 18};
    assertEquals(4, solution.lengthOfLIS(input));
  }
}
