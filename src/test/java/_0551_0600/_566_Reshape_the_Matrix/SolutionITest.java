package _0551_0600._566_Reshape_the_Matrix;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 1/29/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[][] input = {
        {1, 2},
        {3, 4}
    }, expected = {{1, 2, 3, 4}},
        actual = solution.matrixReshape(input, 1, 4);
    assertArrayEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[][] input = {
        {1, 2},
        {3, 4}
    }, expected = {
        {1, 2},
        {3, 4}
    },
        actual = solution.matrixReshape(input, 2, 4);
    assertArrayEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}