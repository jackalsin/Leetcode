package _1151_1200._1201_Ugly_Number_III;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/21/2019
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int expected = 4, n = 3, a = 2, b = 3, c = 5;
    assertEquals(expected, solution.nthUglyNumber(n, a, b, c));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final int expected = 6, n = 4, a = 2, b = 3, c = 4;
    assertEquals(expected, solution.nthUglyNumber(n, a, b, c));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final int expected = 10, n = 5, a = 2, b = 11, c = 13;
    assertEquals(expected, solution.nthUglyNumber(n, a, b, c));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase4(Solution solution) {
    final int expected = 1999999984, n = 1000000000, a = 2, b = 217983653, c = 336916467;
    assertEquals(expected, solution.nthUglyNumber(n, a, b, c));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}