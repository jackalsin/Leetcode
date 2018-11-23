package _0101_0150._121_Best_Time_to_Buy_and_Sell_Stock;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 6/24/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase() throws Exception {
    final int[] prices = new int[] {7, 1, 5, 3, 6, 4};
    assertEquals(5, solution.maxProfit(prices));
  }
  @Test
  public void testOnlineCaseZeroProfit() throws Exception {
    final int[] prices = new int[] {7, 6, 5, 4, 3, 1};
    assertEquals(0, solution.maxProfit(prices));
  }

}