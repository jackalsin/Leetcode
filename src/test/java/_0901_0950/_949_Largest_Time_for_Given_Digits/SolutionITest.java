package _0901_0950._949_Largest_Time_for_Given_Digits;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author zhixi
 * @version 1.0 on 9/1/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int[] input = {1, 2, 3, 4};
    final String expected = "23:41", actual = solution.largestTimeFromDigits(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final int[] input = {5, 5, 5, 5};
    final String expected = "", actual = solution.largestTimeFromDigits(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final int[] input = {0, 0, 0, 0};
    final String expected = "00:00", actual = solution.largestTimeFromDigits(input);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}