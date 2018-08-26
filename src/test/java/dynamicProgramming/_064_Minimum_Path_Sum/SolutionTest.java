package dynamicProgramming._064_Minimum_Path_Sum;

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
    final int[][] dp = {
        {1, 3, 1},
        {1, 5, 1},
        {4, 2, 1}
    };
    assertEquals(7, solution.minPathSum(dp));
  }
}