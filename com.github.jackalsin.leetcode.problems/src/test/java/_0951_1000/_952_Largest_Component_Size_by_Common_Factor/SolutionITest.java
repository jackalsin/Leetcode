package _0951_1000._952_Largest_Component_Size_by_Common_Factor;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/27/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[] input = {4, 6, 15, 35};
    assertEquals(4, solution.largestComponentSize(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[] input = {20, 50, 9, 63};
    assertEquals(2, solution.largestComponentSize(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int[] input = {2, 3, 6, 7, 4, 12, 21, 39};
    assertEquals(8, solution.largestComponentSize(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final int[] input = {801, 839, 521, 999, 655, 16, 536, 84, 670, 983, 408, 346, 511, 638, 895};
    assertEquals(12, solution.largestComponentSize(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase5(Solution solution) {
    final int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    assertEquals(6, solution.largestComponentSize(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase6(Solution solution) {
    final int[] input = {289, 451, 324, 229, 935, 584, 492, 215, 460, 212, 535, 601, 762, 158, 69};
    assertEquals(13, solution.largestComponentSize(input));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}