package facebook._020_Valid_Parentheses;

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
  void testEmptyString() {
    assertTrue(solution.isValid(""));
  }

  @Test
  void testIsValid1() {
    assertTrue(solution.isValid("()"));
  }

  @Test
  void testIsValid2() {
    assertTrue(solution.isValid("()[]"));
  }

  @Test
  void testIsValid3() {
    assertTrue(solution.isValid("()[]{}"));
  }

  @Test
  void testIsValid4() {
    assertTrue(solution.isValid("([]{})"));
  }

  @Test
  void testIsValid5() {
    assertFalse(solution.isValid("([)]"));
  }

  @Test
  void testIsValid6() {
    assertFalse(solution.isValid("{(})"));
  }

  @Test
  void testIsValid7() {
    assertFalse(solution.isValid("["));
  }

}