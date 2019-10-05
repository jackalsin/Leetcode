package interviews.linkedin._078_Subsets;

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
    final int[] nums = {1, 2, 3};
    final Set<List<Integer>> expected = Set.of(
        List.of(),
        List.of(1),
        List.of(2),
        List.of(3),
        List.of(1, 2),
        List.of(1, 3),
        List.of(2, 3),
        List.of(1, 2, 3)
    );

    final List<List<Integer>> actual = solution.subsets(nums);
    assertEquals(expected.size(), actual.size());
    assertEquals(expected, new HashSet<>(actual));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new SolutionIII(),
        new SolutionIV()
    );
  }
}