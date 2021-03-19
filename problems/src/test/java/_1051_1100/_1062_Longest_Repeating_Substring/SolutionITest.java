package _1051_1100._1062_Longest_Repeating_Substring;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author zhixi
 * @version 1.0 on 3/7/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    assertEquals(0, solution.longestRepeatingSubstring("abcd"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    assertEquals(2, solution.longestRepeatingSubstring("abbaba"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    //                                                             012345678
    assertEquals(3, solution.longestRepeatingSubstring("aabcaabdaab"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    assertEquals(4, solution.longestRepeatingSubstring("aaaaa"));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new DpSolution(),
        new SuffixTreeSolution(),
        new SampleSuffixSolution()
    );
  }
}