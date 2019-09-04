package interviews.linkedin._322_Coin_Change;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int[] coins = {1, 2, 5};
    assertEquals(3, solution.coinChange(coins, 11));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final int[] coins = {2};
    assertEquals(-1, solution.coinChange(coins, 3));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailedCase1(Solution solution) {
    final int[] coins = {186, 419, 83, 408};
    assertEquals(20, solution.coinChange(coins, 6249));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailedCase2(Solution solution) {
    final int[] coins = {1, 2147483647};
    assertEquals(2, solution.coinChange(coins, 2));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new DfsSolution(),
        new DfsSolutionI(),
        new DfsSolutionII(),
        new DpSolution(),
        new DpSolutionI(),
        new DpSolutionII()
    );
  }

}