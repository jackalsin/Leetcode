package interviews.linkedin.mianjing._746_Min_Cost_Climbing_Stairs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final int[] cost = {10, 15, 20};
    final int actual = solution.minCostClimbingStairs(cost);
    assertEquals(15, actual);
  }

  @Test
  void testOnlineCase2() {
    final int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
    final int actual = solution.minCostClimbingStairs(cost);
    assertEquals(6, actual);
  }
}