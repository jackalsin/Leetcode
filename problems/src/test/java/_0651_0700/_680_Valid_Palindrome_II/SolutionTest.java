package _0651_0700._680_Valid_Palindrome_II;

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
    assertTrue(solution.validPalindrome("aba"));
  }

  @Test
  void testOnlineCase2() {
    assertTrue(solution.validPalindrome("abca"));
  }

  @Test
  void testOnlineCase3() {
    assertFalse(solution.validPalindrome("abecdba"));
  }


}