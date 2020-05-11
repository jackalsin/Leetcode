package _0951_1000._963_Minimum_Area_Rectangle_II;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/3/2020
 */
class SolutionITest {
  private static final double BIAS = 1E-6;

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[][] points = {{1, 2}, {2, 1}, {1, 0}, {0, 1}};
    assertEquals(2, solution.minAreaFreeRect(points), BIAS);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[][] points = {{0, 1}, {2, 1}, {1, 1}, {1, 0}, {2, 0}};
    assertEquals(1, solution.minAreaFreeRect(points), BIAS);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int[][] points = {{0, 3}, {1, 2}, {3, 1}, {1, 3}, {2, 1}};
    assertEquals(0, solution.minAreaFreeRect(points), BIAS);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final int[][] points = {{3, 1}, {1, 1}, {0, 1}, {2, 1}, {3, 3}, {3, 2}, {0, 2}, {2, 3}};
    assertEquals(2, solution.minAreaFreeRect(points), BIAS);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new ON3Solution(),
        new ON2Solution()
    );
  }
}