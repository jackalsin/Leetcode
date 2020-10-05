package _0901_0950._902_Numbers_At_Most_N_Given_Digit_Set;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/16/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final String digits[] = {"1", "3", "5", "7"};
    final int n = 100, expected = 20, actual = solution.atMostNGivenDigitSet(digits, n);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final String digits[] = {"1", "4", "9"};
    final int n = 1000000000, expected = 29523, actual = solution.atMostNGivenDigitSet(digits, n);
    assertEquals(expected, actual);

  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final String digits[] = {"7"};
    final int n = 8, expected = 1, actual = solution.atMostNGivenDigitSet(digits, n);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase0(Solution solution) {
    final String digits[] = {"7"};
    final int n = 0, expected = 0, actual = solution.atMostNGivenDigitSet(digits, n);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCase1(Solution solution) {
    final String digits[] = {"3", "4", "8"};
    final int n = 4, expected = 2, actual = solution.atMostNGivenDigitSet(digits, n);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCase2(Solution solution) {
    final String digits[] = {"1", "3", "4"};
    // 1, 3, 4, 11, 13,
    // 14, 31, 33, 34, 41,
    // 43
    final int n = 43, expected = 11, actual = solution.atMostNGivenDigitSet(digits, n);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCase3(Solution solution) {
    final String digits[] = {"5", "6"};
    final int n = 19, expected = 2, actual = solution.atMostNGivenDigitSet(digits, n);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCase4(Solution solution) {
    final String digits[] = {"5", "7", "8"};
    // 5, 7, 8
    // 55, 57, 58
    final int n = 59, expected = 6, actual = solution.atMostNGivenDigitSet(digits, n);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}