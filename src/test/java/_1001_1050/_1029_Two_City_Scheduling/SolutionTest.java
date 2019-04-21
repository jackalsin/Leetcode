package _1001_1050._1029_Two_City_Scheduling;

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
    final int[][] costs = {
        // -10    -170        350       10
        {10, 20}, {30, 200}, {400, 50}, {30, 20},
    };
    assertEquals(110, solution.twoCitySchedCost(costs));
  }
}