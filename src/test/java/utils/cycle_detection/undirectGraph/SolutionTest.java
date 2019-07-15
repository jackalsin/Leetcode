package utils.cycle_detection.undirectGraph;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 7/15/2019
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testSelfCycle(Solution solution) {
    final int[][] input = {{0, 0}};
    assertTrue(solution.hasCycle(1, input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testHasCycle(Solution solution) {
    final int[][] input = {
        {0, 1},
        {1, 2},
        {1, 3},
        {1, 4},
        {0, 4},
    };
    assertTrue(solution.hasCycle(5, input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testHasNoCycle(Solution solution) {
    final int[][] input = {
        {0, 1},
        {1, 2},
        {1, 3},
        {1, 4},
    };
    assertFalse(solution.hasCycle(5, input));
  }


  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new DfsSolution()
    );
  }

}