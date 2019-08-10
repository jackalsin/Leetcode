package interviews.linkedin._265_Paint_House_II;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 8/7/2019
 */
class SolutionTest {
  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int[][] nums = {{1, 5, 3}, {2, 9, 4}};
    assertEquals(5, solution.minCostII(nums));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final int[][] nums = {
        {10, 15, 12, 14, 18, 5},
        {5, 12, 18, 13, 15, 8},
        {4, 7, 4, 2, 10, 18},
        {20, 9, 9, 19, 20, 5},
        {10, 15, 10, 15, 16, 20},
        {9, 6, 11, 10, 12, 11},
        {7, 10, 6, 12, 20, 8},
        {3, 4, 4, 18, 10, 2}
    };
    assertEquals(41, solution.minCostII(nums));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}