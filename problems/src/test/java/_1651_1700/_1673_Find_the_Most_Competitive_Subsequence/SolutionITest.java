package _1651_1700._1673_Find_the_Most_Competitive_Subsequence;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author zhixi
 * @version 1.0 on 11/30/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int nums[] = {3, 5, 2, 6}, k = 2, expected[] = {2, 6},
        actual[] = solution.mostCompetitive(nums, k);
    assertArrayEquals(expected, actual, Arrays.toString(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final int nums[] = {2, 4, 3, 3, 5, 4, 9, 6}, k = 4, expected[] = {2, 3, 3, 4},
        actual[] = solution.mostCompetitive(nums, k);
    assertArrayEquals(expected, actual, Arrays.toString(actual));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new DpSolution(),
        new MonoDecreasingStackSolution()
    );
  }
}