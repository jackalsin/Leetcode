package lime._261_Graph_Valid_Tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 4/3/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testPositive(Solution solution) {
    final int[][] edges = new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}};
    assertTrue(solution.validTree(5, edges));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testNegative(Solution solution) {
    final int[][] edges = new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
    assertFalse(solution.validTree(5, edges));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test2Components(Solution solution) {
    final int[][] edges = new int[][]{{0, 1}, {2, 3}};
    assertFalse(solution.validTree(4, edges));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailed(Solution solution) {
    final int[][] edges = new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}};
    assertTrue(solution.validTree(5, edges));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}