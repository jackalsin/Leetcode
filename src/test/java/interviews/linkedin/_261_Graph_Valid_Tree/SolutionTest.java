package interviews.linkedin._261_Graph_Valid_Tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testPositive(Solution solution) {
    final int[][] edges = new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}};
    assertTrue(solution.validTree(5, edges));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testNegative(Solution solution) {
    final int[][] edges = new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
    assertFalse(solution.validTree(5, edges));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void test2Components(Solution solution) {
    final int[][] edges = new int[][]{{0, 1}, {2, 3}};
    assertFalse(solution.validTree(4, edges));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailed(Solution solution) {
    final int[][] edges = new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}};
    assertTrue(solution.validTree(5, edges));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailed1(Solution solution) {
    final int[][] edges = {{0, 1}, {0, 4}, {1, 4}, {2, 3}};
    assertFalse(solution.validTree(5, edges));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new UnionFindISolution(),
        new SolutionII(),
        new DfsSolution(),
        new UnionFindSolutionI(),
        new UnionFindSolutionII(),
        new DfsSolutionI()
    );
  }
}