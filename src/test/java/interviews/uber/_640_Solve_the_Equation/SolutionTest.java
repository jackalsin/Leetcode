package interviews.uber._640_Solve_the_Equation;

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
    final String input = "x+5-3+x=6+x-2", expected = "x=2",
        actual = solution.solveEquation(input);
    assertEquals(expected, actual);
  }

  @Test
  void testOnlineCase2() {
    final String input = "x=x", expected = "Infinite solutions",
        actual = solution.solveEquation(input);
    assertEquals(expected, actual);
  }

  @Test
  void testOnlineCase3() {
    final String input = "2x=x", expected = "x=0",
        actual = solution.solveEquation(input);
    assertEquals(expected, actual);
  }

  @Test
  void testOnlineCase4() {
    final String input = "2x+3x-6x=x+2", expected = "x=-1",
        actual = solution.solveEquation(input);
    assertEquals(expected, actual);
  }

  @Test
  void testOnlineCase5() {
    final String input = "x=x+2", expected = "No solution",
        actual = solution.solveEquation(input);
    assertEquals(expected, actual);
  }

  @Test
  void testOnlineCase6() {
    final String input = "-x=-1", expected = "x=1",
        actual = solution.solveEquation(input);
    assertEquals(expected, actual);
  }

  @Test
  void testOnlineCase7() {
    final String input = "0x=0", expected = "Infinite solutions",
        actual = solution.solveEquation(input);
    assertEquals(expected, actual);
  }
}