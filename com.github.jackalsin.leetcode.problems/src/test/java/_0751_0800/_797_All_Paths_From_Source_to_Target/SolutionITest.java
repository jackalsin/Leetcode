package _0751_0800._797_All_Paths_From_Source_to_Target;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 8/30/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[][] graph = {
        {1, 2}, {3}, {3}, {}
    };
    final Set<List<Integer>> expected = Set.of(
        List.of(0, 1, 3),
        List.of(0, 2, 3)
    );
    final List<List<Integer>> actual = solution.allPathsSourceTarget(graph);
    assertEquals(expected.size(), actual.size());
    assertEquals(expected, new HashSet<>(actual));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}