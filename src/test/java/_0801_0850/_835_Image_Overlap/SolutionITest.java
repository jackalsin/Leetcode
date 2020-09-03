package _0801_0850._835_Image_Overlap;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/2/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[][] A = {
        {1, 1, 0},
        {0, 1, 0},
        {0, 1, 0}},
        B = {{0, 0, 0},
            {0, 1, 1},
            {0, 0, 1}};
    assertEquals(3, solution.largestOverlap(A, B));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}