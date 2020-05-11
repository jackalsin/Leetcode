package interviews.tableau._785_Is_Graph_Bipartite;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 2/17/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[][] graph = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
    assertTrue(solution.isBipartite(graph));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[][] graph = {
        {1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}
    };
    assertFalse(solution.isBipartite(graph));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}