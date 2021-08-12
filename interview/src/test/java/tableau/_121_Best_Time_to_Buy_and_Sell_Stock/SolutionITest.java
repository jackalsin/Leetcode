package tableau._121_Best_Time_to_Buy_and_Sell_Stock;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/13/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase(Solution solution) {
    final int[] prices = new int[]{7, 1, 5, 3, 6, 4};
    assertEquals(5, solution.maxProfit(prices));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCaseZeroProfit(Solution solution) {
    final int[] prices = new int[]{7, 6, 5, 4, 3, 1};
    assertEquals(0, solution.maxProfit(prices));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}