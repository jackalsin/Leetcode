package _1051_1100._1067_Digit_Count_in_Range;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 12/6/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int d = 1, low = 1, high = 13, expected = 6, actual = solution.digitsCount(d, low, high);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int d = 3, low = 100, high = 250, expected = 35, actual = solution.digitsCount(d, low, high);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int d = 0, low = 1, high = 10, expected = 1, actual = solution.digitsCount(d, low, high);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final int d = 0, low = 625, high = 1250, expected = 223, actual = solution.digitsCount(d, low, high);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}