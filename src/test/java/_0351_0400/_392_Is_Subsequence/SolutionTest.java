package _0351_0400._392_Is_Subsequence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final String s = "abc", t = "ahbgdc";
    assertTrue(solution.isSubsequence(s, t));
  }

  @Test
  void testOnlineCase2() {
    final String s = "axc", t = "ahbgdc";
    assertFalse(solution.isSubsequence(s, t));
  }

  @Test
  void testFailedOnEmpty() {
    final String s = "", t = "ahbgdc";
    assertTrue(solution.isSubsequence(s, t));
  }
}