package _0001_0050._009_Palindrome_Number;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 2017/1/13.
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testMinValue(Solution solution) {
    assertFalse(solution.isPalindrome(Integer.MIN_VALUE));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testMaxValue(Solution solution) {
    assertFalse(solution.isPalindrome(Integer.MAX_VALUE));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testZero(Solution solution) {
    assertTrue(solution.isPalindrome(0));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testSingleDigit(Solution solution) {
    assertTrue(solution.isPalindrome(1));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testTwoDigits(Solution solution) {
    assertTrue(solution.isPalindrome(11));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testThreeDigits(Solution solution) {
    assertTrue(solution.isPalindrome(121));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFourDigits(Solution solution) {
    assertTrue(solution.isPalindrome(1221));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new Solution()
    );
  }
}