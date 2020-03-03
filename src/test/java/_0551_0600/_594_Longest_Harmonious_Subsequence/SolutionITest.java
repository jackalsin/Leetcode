package _0551_0600._594_Longest_Harmonious_Subsequence;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/2/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int[] input = {1, 3, 2, 2, 5, 2, 3, 7};
    assertEquals(5, solution.findLHS(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1111(Solution solution) {
    final int[] input = {1, 1, 1, 1};
    assertEquals(0, solution.findLHS(input));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}