package _301_350._301_Remove_Invalid_Parentheses;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 9/11/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final String input = "()())()";
    final Set<String> expected = new HashSet<String>() {{
      add("()()()");
      add("(())()");
    }};
    final List<String> actual = solution.removeInvalidParentheses(input);
    assertEquals(expected, new HashSet<>(actual));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final String input = "(a)())()";
    final Set<String> expected = new HashSet<String>() {{
      add("(a)()()");
      add("(a())()");
    }};
    final List<String> actual = solution.removeInvalidParentheses(input);
    assertEquals(expected, new HashSet<>(actual));
  }

  @Test
  public void testOnlineCase3() throws Exception {
    final String input = ")(";
    final Set<String> expected = new HashSet<String>() {{
      add("");
    }};
    final List<String> actual = solution.removeInvalidParentheses(input);
    assertEquals(expected, new HashSet<>(actual));
  }

}
