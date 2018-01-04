package _701_750._727_Minimum_Window_Subsequence;

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
    final String S = "abcdebdde", T = "bde", expected = "bcde";
    assertEquals(expected, solution.minWindow(S, T));
  }
}