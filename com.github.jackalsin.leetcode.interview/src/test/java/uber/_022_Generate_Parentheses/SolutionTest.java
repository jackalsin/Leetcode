package uber._022_Generate_Parentheses;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/12/2018.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void testWith0() throws Exception {
    assertEquals(Collections.singletonList(""), solution.generateParenthesis(0));
  }

  @Test
  void testWith1() throws Exception {
    assertEquals(Collections.singletonList("()"), solution.generateParenthesis(1));
  }

  @Test
  void testWith2() throws Exception {
    final List<String> sampleAns = Arrays.asList("()()", "(())");
    final List<String> actualAns = solution.generateParenthesis(2);
    assertEquals(new HashSet<>(sampleAns), new HashSet<>(actualAns));
    assertEquals(sampleAns.size(), actualAns.size());
  }

  @Test
  void testWith3() throws Exception {
    final List<String> sampleInOrderAns =
        Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()");
    final List<String> actualAns = solution.generateParenthesis(3);
    assertEquals(
        new HashSet<>(sampleInOrderAns),
        new HashSet<>(actualAns)
    );
    assertEquals(sampleInOrderAns.size(), actualAns.size());
  }
}
