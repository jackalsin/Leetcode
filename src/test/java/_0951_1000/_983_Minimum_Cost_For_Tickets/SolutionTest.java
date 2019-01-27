package _0951_1000._983_Minimum_Cost_For_Tickets;

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
    final int[] days = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31}, costs = {2, 7, 15};
    assertEquals(17, solution.mincostTickets(days, costs));
  }

  @Test
  void testOnlineCase2() {
    final int[] days = {1, 4, 6, 7, 8, 20}, costs = {2, 7, 15};
    assertEquals(11, solution.mincostTickets(days, costs));
  }
}