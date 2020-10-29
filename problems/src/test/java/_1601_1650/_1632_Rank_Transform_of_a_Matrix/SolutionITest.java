package _1601_1650._1632_Rank_Transform_of_a_Matrix;

import definition.TwoDimensionArray;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 10/28/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[][] input = {{20, -21, 14}, {-19, 4, 19}, {22, -47, 24}, {-19, 4, 19}},
        expected = {{4, 2, 3}, {1, 3, 4}, {5, 1, 6}, {1, 3, 4}},
        actual = solution.matrixRankTransform(input);
    assertArrayEquals(expected, actual, Arrays.deepToString(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[][] input = {{7, 3, 6}, {1, 4, 5}, {9, 8, 2}},
        expected = {{5, 1, 4}, {1, 2, 3}, {6, 3, 1}},
        actual = solution.matrixRankTransform(input);
    assertArrayEquals(expected, actual, Arrays.deepToString(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int[][] input = {
        {-37, -26, -47, -40, -13},
        {22, -11, -44, 47, -6},
        {-35, 8, -45, 34, -31},
        {-16, 23, -6, -43, -20},
        {47, 38, -27, -8, 43}
    }, expected = {
        {3, 4, 1, 2, 7},
        {9, 5, 3, 10, 8},
        {4, 6, 2, 7, 5},
        {7, 9, 8, 1, 6},
        {12, 10, 4, 5, 11}
    }, actual = solution.matrixRankTransform(input);
    TwoDimensionArray.println(actual);
    assertArrayEquals(expected, actual, Arrays.deepToString(actual));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}