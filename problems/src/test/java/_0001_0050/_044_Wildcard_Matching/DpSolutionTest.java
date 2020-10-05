package _0001_0050._044_Wildcard_Matching;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * @author jacka
 * @version 1.0 on 2/23/2017.
 */
class DpSolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new DpSolution();
  }

  @Test
  void testWithAsteriskNoUse() {
    assertTrue(solution.isMatch("ab", "a*b"));
  }

  @Test
  void testWithAsteriskUsed() {
    assertTrue(solution.isMatch("acb", "a*b"));
  }

  @Test
  void testOnlineCase1() {
    final String s = "aa", p = "a";
    assertFalse(solution.isMatch(s, p));
  }

  @Test
  void testOnlineCase2() {
    final String s = "aa", p = "*";
    assertTrue(solution.isMatch(s, p));
  }

  @Test
  void testOnlineCase3() {
    final String s = "cb", p = "?a";
    assertFalse(solution.isMatch(s, p));
  }

  @Test
  void testOnlineCase4() {
    final String s = "adceb", p = "*a*b";
    assertTrue(solution.isMatch(s, p));
  }

  @Test
  void testOnlineCase5() {
    final String s = "acdcb", p = "a*c?b";
    assertFalse(solution.isMatch(s, p));
  }

}