package _0451_0500._488_Zuma_Game;

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
    final String board = "WRRBBW", hand = "RB";
    assertEquals(-1, solution.findMinStep(board, hand));
  }

  @Test
  void testOnlineCase2() {
    final String board = "WWRRBBWW", hand = "WRBRW";
    assertEquals(2, solution.findMinStep(board, hand));
  }

  @Test
  void testOnlineCase3() {
    final String board = "G", hand = "GGGGG";
    assertEquals(2, solution.findMinStep(board, hand));
  }

  @Test
  void testOnlineCase4() {
    final String board = "RBYYBBRRB", hand = "YRBGB";
    assertEquals(3, solution.findMinStep(board, hand));
  }

  // ----------------------- test find min step -------------------------------------
  // test RemoveContinuous
  @Test
  void testRemoveContinuous() {
    final String board = "WWWW", hand = "WW";
    assertEquals("", Solution.removeContinuous(board));
  }
}