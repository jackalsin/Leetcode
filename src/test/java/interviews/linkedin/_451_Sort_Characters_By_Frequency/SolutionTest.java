package interviews.linkedin._451_Sort_Characters_By_Frequency;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final String input = "tree";
    final Set<String> expected = Set.of(
        "eert", "eetr"
    );
    assertTrue(expected.contains(solution.frequencySort(input)));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final String input = "cccaaa";
    final Set<String> expected = Set.of(
        "cccaaa", "aaaccc"
    );
    assertTrue(expected.contains(solution.frequencySort(input)));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final String input = "Aabb";
    final Set<String> expected = Set.of(
        "bbAa", "bbaA"
    );
    assertTrue(expected.contains(solution.frequencySort(input)));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new SolutionIII(),
        new BucketSortingSolution(),
        new BucketSortSolutionI()
    );
  }
}