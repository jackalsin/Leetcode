package _0851_0900._885_Spiral_Matrix_III;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 9/14/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int R = 1, C = 4, r0 = 0, c0 = 0,
        expected[][] = {{0, 0}, {0, 1}, {0, 2}, {0, 3}},
        actual[][] = solution.spiralMatrixIII(R, C, r0, c0);
    assertArrayEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int R = 5, C = 6, r0 = 1, c0 = 4,
        expected[][] = {{1, 4}, {1, 5}, {2, 5}, {2, 4},
            {2, 3}, {1, 3}, {0, 3}, {0, 4}, {0, 5},
            {3, 5}, {3, 4}, {3, 3}, {3, 2}, {2, 2},
            {1, 2}, {0, 2}, {4, 5}, {4, 4}, {4, 3},
            {4, 2}, {4, 1}, {3, 1}, {2, 1}, {1, 1}, {0, 1},
            {4, 0}, {3, 0}, {2, 0}, {1, 0}, {0, 0}},
        actual[][] = solution.spiralMatrixIII(R, C, r0, c0);
    assertArrayEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}