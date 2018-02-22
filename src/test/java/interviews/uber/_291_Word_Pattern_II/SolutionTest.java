package interviews.uber._291_Word_Pattern_II;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
//    solution = new NaiveSolution();
//    solution = new AdvancedSolution();
    solution = new GaojiSolution();
  }

  @Test
  void testOnlineCase1() {
    final String str = "redblueredblue", pattern = "abab";
    assertTrue(solution.wordPatternMatch(pattern, str));
  }

  @Test
  void testOnlineCase2() {
    final String str = "asdasdasdasd", pattern = "aaaa";
    assertTrue(solution.wordPatternMatch(pattern, str));
  }

  @Test
  void testOnlineCase3() {
    final String str = "xyzabcxzyabc", pattern = "aabb";
    assertFalse(solution.wordPatternMatch(pattern, str));
  }

  @Test
  void testFailed() {
    final String str = "aa", pattern = "ab";
    assertFalse(solution.wordPatternMatch(pattern, str));
  }

  @Test
  void testFailed2() {
    final String str = "aaaa", pattern = "aba";
    assertTrue(solution.wordPatternMatch(pattern, str));
  }

  @Test
  void testFailed3() {
    final String str = "dogcatcatdog", pattern = "abba";
    assertTrue(solution.wordPatternMatch(pattern, str));
  }

  @Test
  void testFailed4() {
    final String str = "s", pattern = "";
    assertFalse(solution.wordPatternMatch(pattern, str));
  }

  @Test
  void testFailed5() {
    final String str = "e", pattern = "d";
    assertTrue(solution.wordPatternMatch(pattern, str));
  }

}