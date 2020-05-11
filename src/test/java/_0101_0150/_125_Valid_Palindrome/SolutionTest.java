package _0101_0150._125_Valid_Palindrome;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 6/26/2017.
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testEmpty(Solution solution) {
    assertTrue(solution.isPalindrome(""));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test1(Solution solution) {
    assertTrue(solution.isPalindrome("1"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test2True(Solution solution) {
    assertTrue(solution.isPalindrome("11"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test2False(Solution solution) {
    assertFalse(solution.isPalindrome("12"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test3True(Solution solution) {
    assertTrue(solution.isPalindrome("121"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test3False(Solution solution) {
    assertFalse(solution.isPalindrome("122"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testADot(Solution solution) {
    assertTrue(solution.isPalindrome("a."));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new Solution()
    );
  }
}
