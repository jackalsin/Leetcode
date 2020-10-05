package airbnb._322_Coin_Change;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/3/2019.
 */
class SolutionTest {

  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final int[] coins = {1, 2, 5};
    assertEquals(3, solution.coinChange(coins, 11));
  }

  @Test
  void testOnlineCase2() {
    final int[] coins = {2};
    assertEquals(-1, solution.coinChange(coins, 3));
  }

  @Test
  void testOnlineCase3() {
    final int[] coins = {1, 2, 4};
    assertEquals(8000, solution.coinChange(coins, 32000));
  }

  @Test
  void testOnlineCase4() {
    final int[] coins = {1};
    assertEquals(19999, solution.coinChange(coins, 19999));
  }

  @Test
  void testOnlineCase5() {
    final int[] coins = {186, 419, 83, 408};
    assertEquals(20, solution.coinChange(coins, 6249));
  }

  @Test
  void testFailedCase1() {
    final int[] coins = {1, Integer.MAX_VALUE};
    assertEquals(2, solution.coinChange(coins, 2));
  }

}