package newsbreak._047_Permutations_II;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/30/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
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
  void testOnlineCase2(Solution solution) {
    final List<List<Integer>> expected = new ArrayList<>();
    expected.add(List.of(1, 1, 2));
    expected.add(List.of(1, 2, 1));
    expected.add(List.of(2, 1, 1));
    final List<List<Integer>> actual = solution.permuteUnique(new int[]{1, 1, 2});
    assertEquals(expected.size(), actual.size());
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}