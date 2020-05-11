package _0951_1000._994_Rotting_Oranges;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 12/23/2019
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[][] input = {
        {2, 1, 1},
        {1, 1, 0},
        {0, 1, 1}
    };
    assertEquals(4, solution.orangesRotting(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[][] input = {
        {2, 1, 1},
        {0, 1, 1},
        {1, 0, 1}
    };
    assertEquals(-1, solution.orangesRotting(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int[][] input = {
        {0, 2}
    };
    assertEquals(0, solution.orangesRotting(input));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}