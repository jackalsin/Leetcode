package _0901_0950._913_Cat_and_Mouse;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[][] input = {
        {2, 5}, {3}, {0, 4, 5}, {1, 4, 5}, {2, 3}, {0, 2, 3}
    };
    assertEquals(0, solution.catMouseGame(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[][] input = {
        {6}, {4, 11}, {9, 12}, {5}, {1, 5, 11}, {3, 4, 6}, {0, 5, 10}, {8, 9, 10}, {7}, {2, 7, 12}, {6, 7}, {1, 4},
        {2, 9}
    };
    assertEquals(1, solution.catMouseGame(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int[][] input = {
        {6}, {4}, {9}, {5}, {1, 5}, {3, 4, 6}, {0, 5, 10}, {8, 9, 10}, {7}, {2, 7}, {6, 7}
    };
    assertEquals(1, solution.catMouseGame(input));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SampleSolution(),
        new SolutionI()
    );
  }
}