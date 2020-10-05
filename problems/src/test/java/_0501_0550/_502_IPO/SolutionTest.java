package _0501_0550._502_IPO;

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
    final int k = 2, W = 0;
    final int[] Profits = {1, 2, 3}, Capital = {0, 1, 1};
    assertEquals(4, solution.findMaximizedCapital(k, W, Profits, Capital));
  }

  @Test
  void testZeroValidateProject() {
    final int k = 2, W = 0;
    final int[] Profits = {1, 2, 3}, Capital = {1, 1, 1};
    assertEquals(0, solution.findMaximizedCapital(k, W, Profits, Capital));
  }
}