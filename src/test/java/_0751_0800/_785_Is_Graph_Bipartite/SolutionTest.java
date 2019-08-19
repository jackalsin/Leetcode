package _0751_0800._785_Is_Graph_Bipartite;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int[][] graph = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
    assertTrue(solution.isBipartite(graph));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final int[][] graph = {
        {1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}
    };
    assertFalse(solution.isBipartite(graph));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new BfsSolution(),
        new DfsSolution()
    );
  }

}