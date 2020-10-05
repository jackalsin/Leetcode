package _0001_0050._046_Permutations;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/25/2017.
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWithSingleElement(Solution solution) {
    final List<List<Integer>> expected = new ArrayList<>();
    expected.add(Collections.singletonList(1));
    assertEquals(expected, solution.permute(new int[]{1}));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWithMultipleElements(Solution solution) {
    final Set<List<Integer>> expected = new HashSet<>();
    expected.add(List.of(1, 2, 3));
    expected.add(List.of(1, 3, 2));
    expected.add(List.of(2, 1, 3));
    expected.add(List.of(2, 3, 1));
    expected.add(List.of(3, 1, 2));
    expected.add(List.of(3, 2, 1));

    List<List<Integer>> actual = solution.permute(new int[]{1, 2, 3});
    assertEquals(expected.size(), actual.size());
    assertEquals(expected, new HashSet<>(actual));

  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWithEmptyArray(Solution solution) {
    assertEquals(new ArrayList<>(), solution.permute(new int[]{}));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new DfsSolution(),
        new SwapSolution()
    );
  }
}