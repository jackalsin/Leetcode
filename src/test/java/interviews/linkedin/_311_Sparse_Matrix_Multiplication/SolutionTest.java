package interviews.linkedin._311_Sparse_Matrix_Multiplication;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 10/22/2017.
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase(Solution solution) throws Exception {
    final int[][] A = {
        {1, 0, 0},
        {-1, 0, 3}
    };
    final int[][] B = {
        {7, 0, 0},
        {0, 0, 0},
        {0, 0, 1}
    };

    final int[][] C = {{7, 0, 0}, {-7, 0, 3}};
    assertTrue(Arrays.deepEquals(C, solution.multiply(A, B)));

  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new SolutionIII(),
        new SolutionIV()
    );
  }

}
