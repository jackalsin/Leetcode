package _001_100._022_Generate_Parentheses;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;

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
  public void testWith0() throws Exception {
    assertEquals(Collections.singletonList(""), solution.generateParenthesis(0));
  }

  @Test
  public void testWith1() throws Exception {
    assertEquals(Collections.singletonList("()"), solution.generateParenthesis(1));
  }

  @Test
  public void testWith2() throws Exception {
    final List<String> sampleAns = Arrays.asList("()()", "(())");
    final List<String> actualAns = solution.generateParenthesis(2);
    assertEquals(new HashSet<>(sampleAns), new HashSet<>(actualAns));
    assertEquals(sampleAns.size(), actualAns.size());
  }

  @Test
  public void testWith3() throws Exception {
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