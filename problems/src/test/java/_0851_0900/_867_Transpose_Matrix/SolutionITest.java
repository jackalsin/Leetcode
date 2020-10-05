package _0851_0900._867_Transpose_Matrix;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 9/12/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[][] A = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}}, expected =
        {{1, 4, 7},
            {2, 5, 8},
            {3, 6, 9}}, actual = solution.transpose(A);
    assertArrayEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[][] A = {
        {1, 2, 3},
        {4, 5, 6}}, expected =
        {{1, 4}, {2, 5},
            {3, 6}}, actual = solution.transpose(A);
    assertArrayEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}