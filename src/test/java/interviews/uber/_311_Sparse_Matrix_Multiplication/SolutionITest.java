package interviews.uber._311_Sparse_Matrix_Multiplication;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 1/7/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase(Solution solution) {
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

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}