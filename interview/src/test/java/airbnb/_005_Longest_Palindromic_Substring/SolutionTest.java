package airbnb._005_Longest_Palindromic_Substring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final String input = "cbbd";
    assertEquals("bb", solution.longestPalindrome(input));
  }

  @Test
  void testOnlineCase2() {
    final String input = "babad";
    assertEquals("bab", solution.longestPalindrome(input));
  }
}