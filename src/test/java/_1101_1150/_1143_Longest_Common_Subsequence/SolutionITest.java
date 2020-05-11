package _1101_1150._1143_Longest_Common_Subsequence;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/26/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final String text1 = "abcde", text2 = "ace";
    final int expected = 3, actual = solution.longestCommonSubsequence(text1, text2);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final String text1 = "abc", text2 = "abc";
    final int expected = 3, actual = solution.longestCommonSubsequence(text1, text2);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final String text1 = "abc", text2 = "def";
    final int expected = 0, actual = solution.longestCommonSubsequence(text1, text2);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final String text1 = "ezupkr", text2 = "ubmrapg";
    final int expected = 2, actual = solution.longestCommonSubsequence(text1, text2);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}