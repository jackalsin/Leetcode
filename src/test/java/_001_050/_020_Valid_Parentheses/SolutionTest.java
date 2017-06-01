package _001_050._020_Valid_Parentheses;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 1/23/2017.
 */
public class SolutionTest {

  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testEmptyString() throws Exception {
    assertTrue(solution.isValid(""));
  }

  @Test
  public void testIsValid1() throws Exception {
    assertTrue(solution.isValid("()"));
  }

  @Test
  public void testIsValid2() throws Exception {
    assertTrue(solution.isValid("()[]"));
  }

  @Test
  public void testIsValid3() throws Exception {
    assertTrue(solution.isValid("()[]{}"));
  }

  @Test
  public void testIsValid4() throws Exception {
    assertTrue(solution.isValid("([]{})"));
  }

  @Test
  public void testIsValid5() throws Exception {
    assertFalse(solution.isValid("([)]"));
  }

  @Test
  public void testIsValid6() throws Exception {
    assertFalse(solution.isValid("{(})"));
  }

  @Test
  public void testIsValid7() throws Exception {
    assertFalse(solution.isValid("["));
  }

}
