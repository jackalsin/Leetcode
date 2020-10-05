package _0901_0950._912_Sort_an_Array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 9/19/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[] input = {}, expected = {}, actual = solution.sortArray(input);
    assertArrayEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[] input = {1}, expected = {1}, actual = solution.sortArray(input);
    assertArrayEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int[] input = {1, 2}, expected = {1, 2}, actual = solution.sortArray(input);
    assertArrayEquals(expected, actual, "actual = " + Arrays.toString(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final int[] input = {3, 2, 1}, expected = {1, 2, 3}, actual = solution.sortArray(input);
    assertArrayEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}