package interviews.microsoft._020_Valid_Parentheses;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
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