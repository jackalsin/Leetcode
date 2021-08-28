package airbnb._322_Coin_Change;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/3/2019.
 */
class SolutionTest {

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[] coins = {1, 2, 5};
    assertEquals(3, solution.coinChange(coins, 11));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final int[] coins = {2};
    assertEquals(-1, solution.coinChange(coins, 3));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final int[] coins = {1, 2, 4};
    assertEquals(8000, solution.coinChange(coins, 32000));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final int[] coins = {1};
    assertEquals(19999, solution.coinChange(coins, 19999));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase5(Solution solution) {
    final int[] coins = {186, 419, 83, 408};
    assertEquals(20, solution.coinChange(coins, 6249));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCase1(Solution solution) {
    final int[] coins = {1, Integer.MAX_VALUE};
    assertEquals(2, solution.coinChange(coins, 2));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCase2(Solution solution) {
    final int[] coins = {484, 395, 346, 103, 329};
    assertEquals(11, solution.coinChange(coins, 4259));
  }

}