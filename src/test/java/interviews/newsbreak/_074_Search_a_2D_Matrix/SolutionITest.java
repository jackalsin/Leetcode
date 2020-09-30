package interviews.newsbreak._074_Search_a_2D_Matrix;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 9/29/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWith1By1(Solution solution) {
    assertTrue(solution.searchMatrix(new int[][]{{1}}, 1));
  }


  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWith1By1False(Solution solution) {
    assertFalse(solution.searchMatrix(new int[][]{{1}}, 0));
  }


  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWith3By3True(Solution solution) {
    final int[][] input = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    for (int i = 1; i < 10; i++) {
      assertTrue(solution.searchMatrix(input, i));
    }
    assertFalse(solution.searchMatrix(input, 0));
    assertFalse(solution.searchMatrix(input, 10));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}