package _0401_0450._439_Ternary_Expression_Parser;

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
    final String input = "T?2:3", expected = "2";
    assertEquals(expected, solution.parseTernary(input));
  }

  @Test
  void testOnlineCase2() {
    final String input = "F?1:T?4:5", expected = "4";
    assertEquals(expected, solution.parseTernary(input));
  }

  @Test
  void testOnlineCase3() {
    final String input = "T?T?F:5:3", expected = "F";
    assertEquals(expected, solution.parseTernary(input));
  }
}