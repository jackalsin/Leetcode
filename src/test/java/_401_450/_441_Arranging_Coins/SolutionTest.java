package _401_450._441_Arranging_Coins;

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
    assertEquals(2, solution.arrangeCoins(5));
  }

  @Test
  void testOnlineCase2() {
    assertEquals(3, solution.arrangeCoins(8));
  }

  @Test
  void testOnlineCase3() {
    assertEquals(4, solution.arrangeCoins(10));
  }

  @Test
  void testFailedCase1() {
    assertEquals(0, solution.arrangeCoins(0));
  }
}