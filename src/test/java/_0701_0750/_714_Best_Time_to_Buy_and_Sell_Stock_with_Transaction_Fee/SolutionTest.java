package _0701_0750._714_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    final int[] prices = {1, 3, 2, 8, 4, 9};
    assertEquals(8, solution.maxProfit(prices, 2));
  }

}