package _0501_0550._516_Longest_Palindromic_Subsequence;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/13/2018.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() throws Exception {
    assertEquals(4, solution.longestPalindromeSubseq("bbbab"));
  }

  @Test
  void testOnlineCase2() throws Exception {
    assertEquals(2, solution.longestPalindromeSubseq("cbbd"));
  }
}
