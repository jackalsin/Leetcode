package interviews.linkedin._256_Paint_House;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testEmpty(Solution solution) {
    final int[][] costs = new int[][]{};
    assertEquals(0, solution.minCost(costs));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOne(Solution solution) {
    final int[][] costs = new int[][]{{7, 2, 6}};
    assertEquals(2, solution.minCost(costs));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testNormal(Solution solution) {
    final int[][] costs = new int[][]{
        {4, 5, 6},
        {1, 20, 21}
    };
    assertEquals(6, solution.minCost(costs));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testNormal2(Solution solution) {
    final int[][] costs = new int[][]{
        {4, 5, 6},
        {1, 20, 21},
        {2, 20, 21}
    };
    assertEquals(26, solution.minCost(costs));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testNormal3(Solution solution) {
    final int[][] costs = new int[][]{
        {17, 2, 17},
        {16, 16, 5},
        {14, 3, 19}
    };
    assertEquals(10, solution.minCost(costs));
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