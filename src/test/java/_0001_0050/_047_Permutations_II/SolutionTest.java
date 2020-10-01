package _0001_0050._047_Permutations_II;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author zhiwei.xin
 * @version 1.0 on 2/26/17.
 */
class SolutionTest {

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SortingSolution(),
        new SwapSolution()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWithUnique(Solution solution) {
    final List<List<Integer>> expected = new ArrayList<>();
    expected.add(List.of(1, 2, 3));
    expected.add(List.of(1, 3, 2));
    expected.add(List.of(2, 1, 3));
    expected.add(List.of(2, 3, 1));
    expected.add(List.of(3, 1, 2));
    expected.add(List.of(3, 2, 1));

    final List<List<Integer>> actual = solution.permuteUnique(new int[]{1, 2, 3});
    assertEquals(expected.size(), actual.size());
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWithDuplicate(Solution solution) {
    final List<List<Integer>> expected = new ArrayList<>();
    expected.add(List.of(1, 1, 2));
    expected.add(List.of(1, 2, 1));
    expected.add(List.of(2, 1, 1));

    final List<List<Integer>> actual = solution.permuteUnique(new int[]{1, 2, 1});
    assertEquals(expected.size(), actual.size());
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWithDuplicate2(Solution solution) {
    final List<List<Integer>> expected = List.of(
        List.of(0, 0, 0, 1, 9),
        List.of(0, 0, 0, 9, 1),
        List.of(0, 0, 1, 0, 9),
        List.of(0, 0, 1, 9, 0),
        List.of(0, 0, 9, 0, 1),
        List.of(0, 0, 9, 1, 0),
        List.of(0, 1, 0, 0, 9),
        List.of(0, 1, 0, 9, 0),
        List.of(0, 1, 9, 0, 0),
        List.of(0, 9, 0, 0, 1),
        List.of(0, 9, 0, 1, 0),
        List.of(0, 9, 1, 0, 0),
        List.of(1, 0, 0, 0, 9),
        List.of(1, 0, 0, 9, 0),
        List.of(1, 0, 9, 0, 0),
        List.of(1, 9, 0, 0, 0),
        List.of(9, 0, 0, 0, 1),
        List.of(9, 0, 0, 1, 0),
        List.of(9, 0, 1, 0, 0),
        List.of(9, 1, 0, 0, 0)
    );

    final List<List<Integer>> actual = solution.permuteUnique(new int[]{1, 0, 0, 0, 9});
    assertEquals(expected.size(), actual.size());
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWithDuplicate3(Solution solution) {
    final List<List<Integer>> expected = List.of(
        List.of(1, 1, 2, 2),
        List.of(1, 2, 1, 2),
        List.of(1, 2, 2, 1),
        List.of(2, 1, 1, 2),
        List.of(2, 1, 2, 1),
        List.of(2, 2, 1, 1)
    );
    final List<List<Integer>> actual = solution.permuteUnique(new int[]{1, 1, 2, 2});
    assertEquals(expected.size(), actual.size());
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWithDuplicate4(Solution solution) {
    final List<List<Integer>> expected = List.of(
        List.of(1, 2, 2),
        List.of(2, 1, 2),
        List.of(2, 2, 1)
    );
    final List<List<Integer>> actual = solution.permuteUnique(new int[]{1, 2, 2});
    System.out.println(actual);
    assertEquals(expected.size(), actual.size());
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
  }
}