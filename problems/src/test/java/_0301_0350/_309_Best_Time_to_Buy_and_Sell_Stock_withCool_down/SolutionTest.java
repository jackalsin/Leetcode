package _0301_0350._309_Best_Time_to_Buy_and_Sell_Stock_withCool_down;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 9/18/2017.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testEmpty() throws Exception {
    final int[] prices = {};
    assertEquals(0, solution.maxProfit(prices));
  }

  @Test
  public void testOnlineCase() throws Exception {
    final int[] prices = {1, 2, 3, 0, 2};
    assertEquals(3, solution.maxProfit(prices));
  }

  @Test
  public void testFailedCase() throws Exception {
    final int[] prices = {2, 1};
    assertEquals(0, solution.maxProfit(prices));
  }
}
