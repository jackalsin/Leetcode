package _0001_0050._020_Valid_Parentheses;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class O1SpaceSolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new O1SpaceSolution();
  }

  @Test
  void testEmptyString() throws Exception {
    assertTrue(solution.isValid(""));
  }

  @Test
  void testIsValid1() throws Exception {
    assertTrue(solution.isValid("()"));
  }

  @Test
  void testIsValid2() throws Exception {
    assertTrue(solution.isValid("()[]"));
  }

  @Test
  void testIsValid3() throws Exception {
    assertTrue(solution.isValid("()[]{}"));
  }

  @Test
  void testIsValid4() throws Exception {
    assertTrue(solution.isValid("([]{})"));
  }

  @Test
  void testIsValid5() throws Exception {
    assertFalse(solution.isValid("([)]"));
  }

  @Test
  void testIsValid6() throws Exception {
    assertFalse(solution.isValid("{(})"));
  }

  @Test
  void testIsValid7() throws Exception {
    assertFalse(solution.isValid("["));
  }
}