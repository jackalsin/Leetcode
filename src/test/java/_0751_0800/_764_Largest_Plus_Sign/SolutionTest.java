package _0751_0800._764_Largest_Plus_Sign;

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
    final int[][] mines = {{4, 2}};
    assertEquals(2, solution.orderOfLargestPlusSign(5, mines));
  }

  @Test
  void testOnlineCase2() {
    final int[][] mines = {};
    assertEquals(1, solution.orderOfLargestPlusSign(2, mines));
  }

  @Test
  void testOnlineCase3() {
    final int[][] mines = {{0, 0}};
    assertEquals(0, solution.orderOfLargestPlusSign(1, mines));
  }

}