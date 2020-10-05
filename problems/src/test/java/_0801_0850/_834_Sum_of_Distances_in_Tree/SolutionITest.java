package _0801_0850._834_Sum_of_Distances_in_Tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 9/2/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int N = 6;
    final int[][] edges = {
        {0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}};
    final int[] expected = {8, 12, 6, 10, 10, 10},
        actual = solution.sumOfDistancesInTree(N, edges);
    assertArrayEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}