package _1401_1450._1439_Find_the_Kth_Smallest_Sum_of_a_Matrix_With_Sorted_Rows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/2/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[][] matrix = {{1, 3, 11}, {2, 4, 6}};
    final int k = 5;
    assertEquals(7, solution.kthSmallest(matrix, k));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[][] matrix = {{1, 3, 11}, {2, 4, 6}};
    final int k = 9;
    assertEquals(17, solution.kthSmallest(matrix, k));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}