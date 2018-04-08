package _351_400._395_Longest_Substring_with_At_Least_K_Repeating_Characters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    assertEquals(3, solution.longestSubstring("aaabb", 3));
  }

  @Test
  void testOnlineCase2() {
    final String s = "ababbc";
    final int k = 2;
    assertEquals(5, solution.longestSubstring(s, k));
  }

  @Test
  void testFailedCase() {
    final String s = "aaabbb";
    final int k = 3;
    assertEquals(6, solution.longestSubstring(s, k));
  }

}