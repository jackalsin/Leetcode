package interviews.oracle._417_Pacific_Atlantic_Water_Flow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 11/29/2019
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testOnlineCase1(Solution solution) {
    final int[][] matrix = {
        {1, 2, 2, 3, 5},
        {3, 2, 3, 4, 4},
        {2, 4, 5, 3, 1},
        {6, 7, 1, 4, 5},
        {5, 1, 1, 2, 4}
    };
    final List<List<Integer>> expected = List.of(
        List.of(0, 4), List.of(1, 3), List.of(1, 4), List.of(2, 2), List.of(3, 0), List.of(3, 1),
        List.of(4, 0));
    final List<List<Integer>> actual = solution.pacificAtlantic(matrix);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testFailedCase1(Solution solution) {
    final int[][] matrix = {
        {1, 2},
        {4, 3}};
    final List<List<Integer>> expected = List.of(
        List.of(1, 0), List.of(0, 1), List.of(1, 1));
    final List<List<Integer>> actual = solution.pacificAtlantic(matrix);
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
    assertEquals(expected.size(), actual.size());
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new BfsSolution(),
        new DfsSolution()
    );
  }
}