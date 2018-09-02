package interviews.linkedin.mianjing._265_Paint_House_II;

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
    final int[][] nums = {{1, 5, 3}, {2, 9, 4}};
    assertEquals(5, solution.minCostII(nums));
  }

}