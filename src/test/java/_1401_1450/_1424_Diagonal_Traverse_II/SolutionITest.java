package _1401_1450._1424_Diagonal_Traverse_II;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 4/11/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final List<List<Integer>> input = List.of(
        List.of(1, 2, 3), List.of(4, 5, 6), List.of(7, 8, 9)
    );
    final int[] expected = new int[]{1, 4, 2, 7, 5, 3, 8, 6, 9},
        actual = solution.findDiagonalOrder(input);
    assertArrayEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final List<List<Integer>> input = List.of(
        List.of(1, 2, 3, 4, 5),
        List.of(6, 7),
        List.of(8),
        List.of(9, 10, 11),
        List.of(12, 13, 14, 15, 16)
    );
    final int[] expected = new int[]{1, 6, 2, 8, 7, 3, 9, 4, 12, 10, 5, 13, 11, 14, 15, 16},
        actual = solution.findDiagonalOrder(input);
    assertArrayEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final List<List<Integer>> input = List.of(
        List.of(1, 2, 3),
        List.of(4),
        List.of(5, 6, 7), List.of(8), List.of(9, 10, 11)
    );
    final int[] expected = new int[]{1, 4, 2, 5, 3, 8, 6, 9, 7, 10, 11},
        actual = solution.findDiagonalOrder(input);
    assertArrayEquals(expected, actual);
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}