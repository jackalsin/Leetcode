package _0001_0050._005_Longest_Palindromic_Substring;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 2017/1/11.
 */
class SolutionTest {

  private static final String ABCD = "abcd";
  private static final String ABBA = "abba";
  private static final String ACA = "aca";
  private static final String ABCDAD = "abcdad";

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void longestPalindromeEndOddAnswer(Solution solution) {
    assertEquals("dad", solution.longestPalindrome(ABCDAD));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void longestPalindromeFullOddAnswer(Solution solution) {
    assertEquals("aca", solution.longestPalindrome(ACA));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void longestPalindromeFullEvenAnswer(Solution solution) {
    assertEquals("abba", solution.longestPalindrome(ABBA));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void longestPalindromeSingleCharAnswer(Solution solution) {
    Set<String> ans = new HashSet<>(Arrays.asList("a", "b", "c", "d"));
    String expect = solution.longestPalindrome(ABCD);
    assertTrue(ans.contains(expect));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new RecursionSolution(),
        new DpSolution()
    );
  }
}