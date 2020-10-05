package linkedin._309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionITest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new SolutionI();
  }

  @Test
  void testEmpty() throws Exception {
    final int[] prices = {};
    assertEquals(0, solution.maxProfit(prices));
  }

  @Test
  void testOnlineCase() throws Exception {
    final int[] prices = {1, 2, 3, 0, 2};
    assertEquals(3, solution.maxProfit(prices));
  }

  @Test
  void testFailedCase() throws Exception {
    final int[] prices = {2, 1};
    assertEquals(0, solution.maxProfit(prices));
  }

}