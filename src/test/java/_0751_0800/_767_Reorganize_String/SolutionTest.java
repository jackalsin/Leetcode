package _0751_0800._767_Reorganize_String;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final String input = "aab", expected = "aba";
    assertEquals(expected, solution.reorganizeString(input));
  }

  @Test
  void testOnlineCase2() {
    final String input = "aaab", expected = "";
    assertEquals(expected, solution.reorganizeString(input));
  }

}