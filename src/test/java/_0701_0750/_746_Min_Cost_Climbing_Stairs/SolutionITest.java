package _0701_0750._746_Min_Cost_Climbing_Stairs;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/25/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[] cost = {10, 15, 20};
    assertEquals(15, solution.minCostClimbingStairs(cost));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
    assertEquals(6, solution.minCostClimbingStairs(cost));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}