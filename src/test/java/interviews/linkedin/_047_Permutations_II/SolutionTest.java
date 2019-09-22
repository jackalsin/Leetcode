package interviews.linkedin._047_Permutations_II;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/17/2017.
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase(Solution solution) {
    final Set<List<Integer>> expected =
        Set.of(List.of(1, 1, 2), List.of(1, 2, 1),
            List.of(2, 1, 1));
    final int[] input = {1, 1, 2};
    assertEquals(expected, new HashSet<>(solution.permuteUnique(input)));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new SolutionIII()
    );
  }
}
