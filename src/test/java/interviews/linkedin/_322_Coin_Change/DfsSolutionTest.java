package interviews.linkedin._322_Coin_Change;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DfsSolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new DfsSolution();
  }

  @Test
  void testOnlineCase1() throws Exception {
    final int[] coins = {1, 2, 5};
    assertEquals(3, solution.coinChange(coins, 11));
  }

  @Test
  void testOnlineCase2() throws Exception {
    final int[] coins = {2};
    assertEquals(-1, solution.coinChange(coins, 3));
  }

  @Test
  void testFailedCase1() throws Exception {
    final int[] coins = {186, 419, 83, 408};
    assertEquals(20, solution.coinChange(coins, 6249));
  }

}