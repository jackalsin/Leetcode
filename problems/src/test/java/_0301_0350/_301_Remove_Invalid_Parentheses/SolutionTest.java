package _0301_0350._301_Remove_Invalid_Parentheses;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 9/11/2017.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
//    solution = new BfsSolution();
    solution = new DfsSolution();
  }

  @Test
  void testOnlineCase1() throws Exception {
    final String input = "()())()";
    final Set<String> expected = new HashSet<String>() {{
      add("()()()");
      add("(())()");
    }};
    final List<String> actual = solution.removeInvalidParentheses(input);
    assertEquals(expected, new HashSet<>(actual));
  }

  @Test
  void testOnlineCase2() throws Exception {
    final String input = "(a)())()";
    final Set<String> expected = new HashSet<String>() {{
      add("(a)()()");
      add("(a())()");
    }};
    final List<String> actual = solution.removeInvalidParentheses(input);
    assertEquals(expected, new HashSet<>(actual));
  }

  @Test
  void testOnlineCase3() throws Exception {
    final String input = ")(";
    final Set<String> expected = new HashSet<String>() {{
      add("");
    }};
    final List<String> actual = solution.removeInvalidParentheses(input);
    assertEquals(expected, new HashSet<>(actual));
  }

  @Test
  void testLRR() throws Exception {
    final String input = "())";
    final Set<String> expected = new HashSet<String>() {{
      add("()");
    }};
    final List<String> actual = solution.removeInvalidParentheses(input);
    assertEquals(expected, new HashSet<>(actual));
  }
}
