package _0801_0850._822_Card_Flipping_Game;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/1/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[] fronts = {1, 2, 4, 4, 7},
        backs = {1, 3, 4, 1, 3};
    assertEquals(2, solution.flipgame(fronts, backs));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[] fronts = {1, 1},
        backs = {1, 2};
    assertEquals(2, solution.flipgame(fronts, backs));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int[] fronts = {2, 1},
        backs = {1, 2};
    assertEquals(1, solution.flipgame(fronts, backs));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}