package _401_450._424_Longest_Repeating_Character_Replacement;

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
    final String s = "ABAB";
    final int k = 2;
    assertEquals(4, solution.characterReplacement(s, k));
  }

  @Test
  void testOnlineCase2() {
    final String s = "AABABBA";
    final int k = 1;
    assertEquals(4, solution.characterReplacement(s, k));
  }
}