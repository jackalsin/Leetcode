package _0801_0850._832_Flipping_an_Image;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 9/2/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[][] input = {
        {1, 1, 0},
        {1, 0, 1},
        {0, 0, 0}
    }, expected = {
        {1, 0, 0},
        {0, 1, 0},
        {1, 1, 1}
    }, actual = solution.flipAndInvertImage(input);
    assertArrayEquals(expected, actual);
  }


  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[][] input = {
        {1, 1, 0, 0},
        {1, 0, 0, 1},
        {0, 1, 1, 1},
        {1, 0, 1, 0}
    }, expected = {
        {1, 1, 0, 0},
        {0, 1, 1, 0},
        {0, 0, 0, 1},
        {1, 0, 1, 0}
    }, actual = solution.flipAndInvertImage(input);
    assertArrayEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}