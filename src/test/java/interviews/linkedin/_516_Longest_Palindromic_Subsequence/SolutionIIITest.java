package interviews.linkedin._516_Longest_Palindromic_Subsequence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionIIITest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new SolutionIII();
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