package dynamicProgramming._032_Longest_Valid_Parentheses;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void testWithAllValid() throws Exception {
    assertEquals(8, solution.longestValidParentheses("(()()())"));
  }

  @Test
  void testWithLeadingValid() throws Exception {
    assertEquals(8, solution.longestValidParentheses("(()()()()"));
  }

  @Test
  void testWithTailingValid() throws Exception {
    assertEquals(8, solution.longestValidParentheses("()()()())"));
  }

  @Test
  void testWithAllInvalid() throws Exception {
    assertEquals(0, solution.longestValidParentheses(")("));
  }
}