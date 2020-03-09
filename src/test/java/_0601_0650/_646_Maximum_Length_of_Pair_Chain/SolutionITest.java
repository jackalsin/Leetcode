package _0601_0650._646_Maximum_Length_of_Pair_Chain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/8/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int[][] input = {
        {1, 2}, {2, 3}, {3, 4}
    };
    assertEquals(2, solution.findLongestChain(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final int[][] input = {
        {9, 10}, {-9, 9}, {-6, 1}, {-4, 1}, {8, 10}, {7, 10}, {9, 10}, {2, 10}
    };
    assertEquals(2, solution.findLongestChain(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final int[][] input = {
        {9, 10}, {9, 10}, {4, 5}, {-9, -3}, {-9, 1}, {0, 3}, {6, 10}, {-5, -4}, {-7, -6}
    };
    assertEquals(5, solution.findLongestChain(input));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}