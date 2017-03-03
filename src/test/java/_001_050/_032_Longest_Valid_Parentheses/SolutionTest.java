package _001_050._032_Longest_Valid_Parentheses;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2017/2/8.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testWithAllValid() throws Exception {
    assertEquals(8, solution.longestValidParentheses("(()()())"));
  }

  @Test
  public void testWithLeadingValid() throws Exception {
    assertEquals(8, solution.longestValidParentheses("(()()()()"));
  }

  @Test
  public void testWithTailingValid() throws Exception {
    assertEquals(8, solution.longestValidParentheses("()()()())"));
  }

  @Test
  public void testWithAllInvalid() throws Exception {
    assertEquals(0, solution.longestValidParentheses(")("));
  }
}