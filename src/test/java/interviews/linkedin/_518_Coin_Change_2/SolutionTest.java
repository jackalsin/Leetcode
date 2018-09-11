package interviews.linkedin._518_Coin_Change_2;

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
  void testOnlineCase1() {
    final int[] coins = {1, 2, 5};
    assertEquals(4, solution.change(5, coins));
  }

  @Test
  void testOnlineCase2() {
    final int[] coins = {2};
    assertEquals(0, solution.change(3, coins));
  }

  @Test
  void testOnlineCase3() {
    final int[] coins = {10};
    assertEquals(1, solution.change(10, coins));
  }


}