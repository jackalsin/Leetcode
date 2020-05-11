package interviews.linkedin._347_Top_K_Frequent_Elements;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 8/11/2019
 */
class SolutionTest {
  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[] nums = {1, 1, 1, 2, 2, 3};
    final Set<Integer> expected = Set.of(1, 2);
    final List<Integer> actual = solution.topKFrequent(nums, 2);
    assertEquals(expected, new HashSet<>(actual));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new PqSolution(),
        new BucketSortSolution(),
        new PqSolutionI(),
        new BucketSolutionI()
    );
  }
}