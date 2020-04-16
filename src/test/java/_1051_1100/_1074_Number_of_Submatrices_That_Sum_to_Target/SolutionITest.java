package _1051_1100._1074_Number_of_Submatrices_That_Sum_to_Target;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/15/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int matrix[][] = {{0, 1, 0}, {1, 1, 1}, {0, 1, 0}}, target = 0;
    assertEquals(4, solution.numSubmatrixSumTarget(matrix, target));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final int matrix[][] = {{1, -1}, {-1, 1}}, target = 0;
    assertEquals(5, solution.numSubmatrixSumTarget(matrix, target));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}