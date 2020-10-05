package _1401_1450._1428_Leftmost_Column_with_at_Least_a_One;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import definition.Leftmost_Column_with_at_Least_a_One.BinaryMatrix;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/21/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[][] matrix = {
        {0, 0}, {1, 1}
    };
    final BinaryMatrix bm = new BinaryMatrix(matrix);
    assertEquals(0, solution.leftMostColumnWithOne(bm));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[][] matrix = {
        {0, 0}, {0, 0}
    };
    final BinaryMatrix bm = new BinaryMatrix(matrix);
    assertEquals(-1, solution.leftMostColumnWithOne(bm));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int[][] matrix = {
        {0, 0}, {0, 1}
    };
    final BinaryMatrix bm = new BinaryMatrix(matrix);
    assertEquals(1, solution.leftMostColumnWithOne(bm));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final int[][] matrix = {
        {0, 0, 0, 1},
        {0, 0, 1, 1},
        {0, 1, 1, 1}
    };
    final BinaryMatrix bm = new BinaryMatrix(matrix);
    assertEquals(1, solution.leftMostColumnWithOne(bm));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}