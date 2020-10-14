package _0951_1000._991_Broken_Calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/12/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int X = 2, Y = 3, expected = 2, actual = solution.brokenCalc(X, Y);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final int X = 5, Y = 8, expected = 2, actual = solution.brokenCalc(X, Y);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final int X = 3, Y = 10, expected = 3, actual = solution.brokenCalc(X, Y);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase4(Solution solution) {
    final int X = 1024, Y = 1, expected = 1023, actual = solution.brokenCalc(X, Y);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase5(Solution solution) {
    final int X = 1, Y = 1000000000, expected = 39, actual = solution.brokenCalc(X, Y);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}