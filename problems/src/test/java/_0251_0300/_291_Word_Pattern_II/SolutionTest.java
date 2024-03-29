package _0251_0300._291_Word_Pattern_II;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 9/6/2017.
 */
class SolutionTest {

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new Solution()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final String str = "redblueredblue", pattern = "abab";
    assertTrue(solution.wordPatternMatch(pattern, str));
  }


  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final String str = "asdasdasdasd", pattern = "aaaa";
    assertTrue(solution.wordPatternMatch(pattern, str));
  }


  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final String str = "xyzabcxzyabc", pattern = "aabb";
    assertFalse(solution.wordPatternMatch(pattern, str));
  }


  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailed(Solution solution) {
    final String str = "aa", pattern = "ab";
    assertFalse(solution.wordPatternMatch(pattern, str));
  }


  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailed2(Solution solution) {
    final String str = "aaaa", pattern = "aba";
    assertTrue(solution.wordPatternMatch(pattern, str));
  }


  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailed3(Solution solution) {
    final String str = "dogcatcatdog", pattern = "abba";
    assertTrue(solution.wordPatternMatch(pattern, str));
  }

}
