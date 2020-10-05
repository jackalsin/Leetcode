package _0551_0600._564_Find_the_Closest_Palindrome;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/2/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase123(Solution solution) {
    final String input = "123",
        expected = "121",
        actual = solution.nearestPalindromic(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final String input = "1",
        expected = "0",
        actual = solution.nearestPalindromic(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final String input = "2",
        expected = "1",
        actual = solution.nearestPalindromic(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase11(Solution solution) {
    final String input = "11",
        expected = "9",
        actual = solution.nearestPalindromic(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase12(Solution solution) {
    final String input = "12",
        expected = "11",
        actual = solution.nearestPalindromic(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase88(Solution solution) {
    final String input = "88",
        expected = "77",
        actual = solution.nearestPalindromic(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase100(Solution solution) {
    final String input = "100",
        expected = "99",
        actual = solution.nearestPalindromic(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase11011(Solution solution) {
    final String input = "11011",
        expected = "11111",
        actual = solution.nearestPalindromic(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1283(Solution solution) {
    final String input = "1283",
        expected = "1331",
        actual = solution.nearestPalindromic(input);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}