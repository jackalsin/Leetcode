package _0701_0750._730_Count_Different_Palindromic_Subsequences;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/13/18
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final String input = "bccb";
    assertEquals(6, solution.countPalindromicSubsequences(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final String input = "abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba";
    assertEquals(104860361, solution.countPalindromicSubsequences(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final String input = "abcb";
    assertEquals(5, solution.countPalindromicSubsequences(input));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new ThreeDimensionDpII(),
        new ThreeDimensionDp()
    );
  }
}