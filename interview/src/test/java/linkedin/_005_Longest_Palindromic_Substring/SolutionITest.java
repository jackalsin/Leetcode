package linkedin._005_Longest_Palindromic_Substring;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionITest {
  private static final String ABCD = "abcd";
  private static final String ABBA = "abba";
  private static final String ACA = "aca";
  private static final String ABCDAD = "abcdad";

  @ParameterizedTest
  @MethodSource("solutionStream")
  void longestPalindromeEndOddAnswer(Solution solution) {
    assertEquals("dad", solution.longestPalindrome(ABCDAD));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void longestPalindromeFullOddAnswer(Solution solution) {
    assertEquals("aca", solution.longestPalindrome(ACA));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void longestPalindromeFullEvenAnswer(Solution solution) {
    assertEquals("abba", solution.longestPalindrome(ABBA));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void longestPalindromeSingleCharAnswer(Solution solution) {
    Set<String> ans = new HashSet<>(Arrays.asList("a", "b", "c", "d"));
    String expect = solution.longestPalindrome(ABCD);
    assertTrue(ans.contains(expect));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new DpSolutionI(),
        new RecursionSolution(),
        new SolutionI()
    );
  }
}