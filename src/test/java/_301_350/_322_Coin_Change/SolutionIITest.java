package _301_350._322_Coin_Change;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/25/2017.
 */
public class SolutionIITest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new SolutionII();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final int[] coins = {1, 2, 5};
    assertEquals(3, solution.coinChange(coins, 11));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final int[] coins = {2};
    assertEquals(-1, solution.coinChange(coins, 3));
  }

  @Test
  public void testOnlineCase3() throws Exception {
    final int[] coins = {1, 2, 4};
    assertEquals(8000, solution.coinChange(coins, 32000));
  }

  @Test
  public void testOnlineCase4() throws Exception {
    final int[] coins = {1};
    assertEquals(19999, solution.coinChange(coins, 19999));
  }

}
