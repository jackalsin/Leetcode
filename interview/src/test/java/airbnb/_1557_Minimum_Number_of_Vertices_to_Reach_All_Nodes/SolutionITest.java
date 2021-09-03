package airbnb._1557_Minimum_Number_of_Vertices_to_Reach_All_Nodes;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author zhixi
 * @version 1.0 on 9/3/2021
 */
class SolutionITest {
  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final List<List<Integer>> input = List.of(
        List.of(0, 1),
        List.of(0, 2),
        List.of(2, 5),
        List.of(3, 4),
        List.of(4, 2)
    );
    final Set<Integer> expected = Set.of(0, 3);
    final List<Integer> actual = solution.findSmallestSetOfVertices(6, input);
    assertEquals(expected.size(), actual.size());
    assertEquals(expected, new HashSet<>(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final List<List<Integer>> input = List.of(
        List.of(0, 1),
        List.of(2, 1),
        List.of(3, 1),
        List.of(1, 4),
        List.of(2, 4)
    );
    final Set<Integer> expected = Set.of(0, 2, 3);
    final List<Integer> actual = solution.findSmallestSetOfVertices(5, input);
    assertEquals(expected.size(), actual.size());
    assertEquals(expected, new HashSet<>(actual));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}