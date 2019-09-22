package interviews.linkedin._046_Permutations;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int[] input = {1, 2, 3};
    final Set<List<Integer>> expected = Set.of(
        List.of(1, 2, 3),
        List.of(1, 3, 2),
        List.of(2, 1, 3),
        List.of(2, 3, 1),
        List.of(3, 2, 1),
        List.of(3, 1, 2)
    );

    final List<List<Integer>> actual = solution.permute(input);
    assertEquals(expected.size(), actual.size());
    assertEquals(expected, new HashSet<>(actual));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new SolutionIII(),
        new SolutionIV(),
        new SwapSolution(),
        new BooleanVisitedSolution()
    );
  }
}