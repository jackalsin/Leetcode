package _0451_0500._467_Unique_Substrings_in_Wraparound_String;

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
    final String input = "a";
    assertEquals(1, solution.findSubstringInWraproundString(input));
  }

  @Test
  void testOnlineCase2() {
    final String input = "cac";
    assertEquals(2, solution.findSubstringInWraproundString(input));
  }

  @Test
  void testOnlineCase3() {
    final String input = "zab";
    assertEquals(6, solution.findSubstringInWraproundString(input));
  }
}