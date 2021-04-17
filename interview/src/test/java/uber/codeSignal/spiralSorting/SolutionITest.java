package uber.codeSignal.spiralSorting;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/17/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testEmptyRow(Solution solution) {
    final int[][] input = {};
    assertEquals(Collections.emptyList(), solution.spiralSorting(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testEmptyCol(Solution solution) {
    final int[][] input = {{}};
    assertEquals(Collections.emptyList(), solution.spiralSorting(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOddRowEvenCol(Solution solution) {
    final int[][] input = {
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
    };
    assertEquals(List.of(
        List.of(1, 2, 3, 4, 5, 8, 9, 10, 11, 12),
        List.of(6, 7)
    ), solution.spiralSorting(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOddRowOddCol(Solution solution) {
    final int[][] input = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9},
    };
    assertEquals(List.of(
        List.of(1, 2, 3, 4, 6, 7, 8, 9),
        List.of(5)
    ), solution.spiralSorting(input));
  }


  @ParameterizedTest
  @MethodSource("solutionStream")
  void testEvenRowEvenCol(Solution solution) {
    final int[][] input = {
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 15, 16},
    };
    assertEquals(List.of(
        List.of(1, 2, 3, 4, 5, 8, 9, 12, 13, 14, 15, 16),
        List.of(6, 7, 10, 11)
    ), solution.spiralSorting(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testEvenRowOddCol(Solution solution) {
    final int[][] input = {
        {1, 2, 3},
        {5, 6, 7},
        {9, 10, 11},
        {13, 14, 15},
    };
    assertEquals(List.of(
        List.of(1, 2, 3, 5, 7, 9, 11, 13, 14, 15),
        List.of(6, 10)
    ), solution.spiralSorting(input));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}