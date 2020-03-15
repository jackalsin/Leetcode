package _1351_1400._1380_Lucky_Numbers_in_a_Matrix;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/14/2020
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int[][] input = {
        {3, 7, 8},
        {9, 11, 13},
        {15, 16, 17}
    };
    assertEquals(List.of(15), solution.luckyNumbers(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final int[][] input = {
        {1, 10, 4, 2},
        {9, 3, 8, 7},
        {15, 16, 17, 12}
    };
    assertEquals(List.of(12), solution.luckyNumbers(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final int[][] input = {
        {7, 8},
        {1, 2}
    };
    assertEquals(List.of(7), solution.luckyNumbers(input));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new Solution()
    );
  }
}