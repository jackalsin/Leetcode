package airbnb._291_Word_Pattern_II;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 2/3/2019.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() throws Exception {
    final String str = "redblueredblue", pattern = "abab";
    assertTrue(solution.wordPatternMatch(pattern, str));
  }

  @Test
  void testOnlineCase2() throws Exception {
    final String str = "asdasdasdasd", pattern = "aaaa";
    assertTrue(solution.wordPatternMatch(pattern, str));
  }

  @Test
  void testOnlineCase3() throws Exception {
    final String str = "xyzabcxzyabc", pattern = "aabb";
    assertFalse(solution.wordPatternMatch(pattern, str));
  }

  @Test
  void testFailed() throws Exception {
    final String str = "aa", pattern = "ab";
    assertFalse(solution.wordPatternMatch(pattern, str));
  }

  @Test
  void testFailed2() throws Exception {
    final String str = "aaaa", pattern = "aba";
    assertTrue(solution.wordPatternMatch(pattern, str));
  }

  @Test
  void testFailed3() throws Exception {
    final String str = "dogcatcatdog", pattern = "abba";
    assertTrue(solution.wordPatternMatch(pattern, str));
  }

  @Test
  void testFailed4() {
    final String pattern = "e", str = "d";
    assertTrue(solution.wordPatternMatch(pattern, str));
  }

  @Test
  void testFailed5() {
    final String pattern = "itwasthebestoftimes", str = "ittwaastthhebesttoofttimes";
    assertTrue(solution.wordPatternMatch(pattern, str));
  }
}