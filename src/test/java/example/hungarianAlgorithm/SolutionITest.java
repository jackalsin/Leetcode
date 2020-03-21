package example.hungarianAlgorithm;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 3/16/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int[][] input = {
        {0, 1}, {0, 3}, {0, 5}, {0, 7},
        {2, 1}, {4, 3}, {6, 5}, {6, 7}
    };
    final Set<List<Integer>> expected = Set.of(
        List.of(7, 2, 1, 4, 3, 6, 5, 0),
        List.of(5, 2, 1, 4, 3, 0, 7, 6)
    );
    final List<Integer> actual = solution.match(8, input);
    assertTrue(expected.contains(actual), "actual is not expected = " + actual);
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}