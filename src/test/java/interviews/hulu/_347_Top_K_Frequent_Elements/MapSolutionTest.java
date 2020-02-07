package interviews.hulu._347_Top_K_Frequent_Elements;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/6/2020
 */
class MapSolutionTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase(Solution solution) throws Exception {
    final int[] nums = {1, 1, 1, 2, 2, 3};
    final Set<Integer> expected = Set.of(1, 2);
    final List<Integer> actual = solution.topKFrequent(nums, 2);
    assertEquals(expected, new HashSet<>(actual));
  }


  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new MapSolution(),
        new BucketSortSolution()
    );
  }
}