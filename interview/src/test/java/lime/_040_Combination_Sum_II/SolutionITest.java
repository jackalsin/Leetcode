package lime._040_Combination_Sum_II;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/4/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWithOnlineCase(Solution solution) {
    List<List<Integer>> expect = List.of(
        List.of(1, 7),
        List.of(1, 2, 5),
        List.of(2, 6),
        List.of(1, 1, 6)
    ), actual = solution.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
    assertEquals(expect.size(), actual.size());
    assertEquals(new HashSet<>(expect), new HashSet<>(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testWithTripleElements(Solution solution) {
    final List<List<Integer>> expect = List.of(
        List.of(1, 1, 6)
    ), actual = solution.combinationSum2(new int[]{1, 1, 1, 6, 10}, 8);
    assertEquals(expect.size(), actual.size());
    assertEquals(new HashSet<>(expect), new HashSet<>(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final List<List<Integer>> expect = List.of(
        List.of(1,2, 2),
        List.of(5)
    ), actual = solution.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5);
    assertEquals(expect.size(), actual.size());
    assertEquals(new HashSet<>(expect), new HashSet<>(actual));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}