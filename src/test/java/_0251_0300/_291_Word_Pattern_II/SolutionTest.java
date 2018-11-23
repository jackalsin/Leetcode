package _0251_0300._291_Word_Pattern_II;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 9/6/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final String str = "redblueredblue", pattern = "abab";
    assertTrue(solution.wordPatternMatch(pattern, str));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final String str = "asdasdasdasd", pattern = "aaaa";
    assertTrue(solution.wordPatternMatch(pattern, str));
  }

  @Test
  public void testOnlineCase3() throws Exception {
    final String str = "xyzabcxzyabc", pattern = "aabb";
    assertFalse(solution.wordPatternMatch(pattern, str));
  }

  @Test
  public void testFailed() throws Exception {
    final String str = "aa", pattern = "ab";
    assertFalse(solution.wordPatternMatch(pattern, str));
  }

  @Test
  public void testFailed2() throws Exception {
    final String str = "aaaa", pattern = "aba";
    assertTrue(solution.wordPatternMatch(pattern, str));
  }

  @Test
  public void testFailed3() throws Exception {
    final String str = "dogcatcatdog", pattern = "abba";
    assertTrue(solution.wordPatternMatch(pattern, str));
  }

}
