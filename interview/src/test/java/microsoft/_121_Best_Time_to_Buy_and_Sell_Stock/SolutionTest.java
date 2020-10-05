package microsoft._121_Best_Time_to_Buy_and_Sell_Stock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase() {
    final int[] prices = new int[]{7, 1, 5, 3, 6, 4};
    assertEquals(5, solution.maxProfit(prices));
  }

  @Test
  void testOnlineCaseZeroProfit() {
    final int[] prices = new int[]{7, 6, 5, 4, 3, 1};
    assertEquals(0, solution.maxProfit(prices));
  }
}