package _0501_0550._532_K_diff_Pairs_in_an_Array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/26/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[] input = {3, 1, 4, 1, 5};
    final int k = 2;
    final int expected = 2;
    assertEquals(expected, solution.findPairs(input, k));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[] input = {1, 2, 3, 4, 5};
    final int k = 1;
    final int expected = 4;
    assertEquals(expected, solution.findPairs(input, k));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int[] input = {1, 3, 1, 5, 4};
    final int k = 0;
    final int expected = 1;
    assertEquals(expected, solution.findPairs(input, k));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final int[] input = {1, 2, 3, 4, 5};
    final int k = -1;
    final int expected = 0;
    assertEquals(expected, solution.findPairs(input, k));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new HashMapSolution()
    );
  }
}