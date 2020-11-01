package _1051_1100._1053_Previous_Permutation_With_One_Swap;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 10/31/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int[] input = {3, 2, 1}, expected = {3, 1, 2},
        actual = solution.prevPermOpt1(input);
    assertArrayEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final int[] input = {1, 1, 5}, expected = {1, 1, 5},
        actual = solution.prevPermOpt1(input);
    assertArrayEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final int[] input = {1, 9, 4, 6, 7}, expected = {1, 7, 4, 6, 9},
        actual = solution.prevPermOpt1(input);
    assertArrayEquals(expected, actual, Arrays.toString(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase4(Solution solution) {
    final int[] input = {3, 1, 1, 3}, expected = {1, 3, 1, 3},
        actual = solution.prevPermOpt1(input);
    assertArrayEquals(expected, actual, Arrays.toString(actual));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}