package _0951_1000._973_K_Closest_Points_to_Origin;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[][] input = {{1, 3}, {-2, 2}}, expected = {{-2, 2}};
    final int K = 1;
    assertArrayEquals(expected, solution.kClosest(input, K));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[][] input = {{3, 3}, {5, -1}, {-2, 4}}, expected = {{3, 3}, {-2, 4}};
    final int K = 2;
    assertArrayEquals(expected, solution.kClosest(input, K));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final int K = 5;
    final int[][] input = {{10, -7}, {-3, 5}, {-6, 5}, {-5, 10}, {4, 6}, {6, 0}},
        expected = {{-3, 5}, {6, 0}, {4, 6}, {-6, 5}, {-5, 10}}, actual = solution.kClosest(input, K);
    assertEquals(getUnordered(expected), getUnordered(actual));
  }

  private static Set<List<Integer>> getUnordered(final int[][] input) {
    final Set<List<Integer>> result = new HashSet<>();
    for (final int[] e : input) {
      result.add(List.of(e[0], e[1]));
    }
    return result;
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new PqSolution(),
        new QuickSelectionSelection()
    );
  }

}