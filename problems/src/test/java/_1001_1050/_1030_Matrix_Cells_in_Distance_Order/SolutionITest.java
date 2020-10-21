package _1001_1050._1030_Matrix_Cells_in_Distance_Order;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 10/20/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int R = 1, C = 2, r0 = 0, c0 = 0;
    final int[][] input = {{0, 0}, {0, 1}};
    assertArrayEquals(input, solution.allCellsDistOrder(R, C, r0, c0));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }
}