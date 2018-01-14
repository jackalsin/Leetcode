package _501_550._516_Longest_Palindromic_Subsequence;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/13/2018.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    assertEquals(4, solution.longestPalindromeSubseq("bbbab"));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    assertEquals(2, solution.longestPalindromeSubseq("cbbd"));
  }
}
