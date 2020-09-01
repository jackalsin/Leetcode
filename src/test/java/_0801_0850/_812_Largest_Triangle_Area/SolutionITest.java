package _0801_0850._812_Largest_Triangle_Area;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 8/31/2020
 */
class SolutionITest {
  private static final double BIAS = 1E-6;

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[][] points = {
        {0, 0}, {0, 1}, {1, 0}, {0, 2}, {2, 0}
    };
    assertEquals(2, solution.largestTriangleArea(points), BIAS);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}