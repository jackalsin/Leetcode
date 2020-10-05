package _0801_0850._846_Hand_of_Straights;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 3/25/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[] input = {1, 2, 3, 6, 2, 3, 4, 7, 8};
    final int W = 3;
    assertTrue(solution.isNStraightHand(input, W));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[] input = {1, 2, 3, 4, 5};
    final int W = 4;
    assertFalse(solution.isNStraightHand(input, W));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int[] input = {1, 2, 3};
    final int W = 1;
    assertTrue(solution.isNStraightHand(input, W));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final int[] input = {2, 1};
    final int W = 2;
    assertTrue(solution.isNStraightHand(input, W));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase5(Solution solution) {
    final int[] input = {1, 1, 2, 2, 3, 3};
    final int W = 3;
    assertTrue(solution.isNStraightHand(input, W));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new Lee215Solution()
    );
  }
}