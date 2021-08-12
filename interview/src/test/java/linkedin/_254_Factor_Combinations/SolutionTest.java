package linkedin._254_Factor_Combinations;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/22/2017.
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test1(Solution solution) {
    assertEquals(new ArrayList<>(), solution.getFactors(1));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test37(Solution solution) {
    assertEquals(new ArrayList<>(), solution.getFactors(37));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test12(Solution solution) {
    final List<List<Integer>> expected = new ArrayList<>();
    expected.add(Arrays.asList(2, 2, 3));
    expected.add(Arrays.asList(2, 6));
    expected.add(Arrays.asList(3, 4));
    List<List<Integer>> actual = solution.getFactors(12);
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
    assertEquals(expected.size(), actual.size());
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test32(Solution solution) {
    final List<List<Integer>> expected = new ArrayList<>();
    expected.add(Arrays.asList(2, 16));
    expected.add(Arrays.asList(2, 2, 8));
    expected.add(Arrays.asList(2, 2, 2, 4));
    expected.add(Arrays.asList(2, 2, 2, 2, 2));
    expected.add(Arrays.asList(2, 4, 4));
    expected.add(Arrays.asList(4, 8));
    List<List<Integer>> actual = solution.getFactors(32);
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
    assertEquals(expected.size(), actual.size());
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new SolutionIII(),
        new SolutionIV(),
        new SolutionV()
    );
  }
}
