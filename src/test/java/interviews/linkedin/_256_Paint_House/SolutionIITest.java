package interviews.linkedin._256_Paint_House;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionIITest {

  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new SolutionII();
  }

  @Test
  void testEmpty() throws Exception {
    final int[][] costs = new int[][]{};
    assertEquals(0, solution.minCost(costs));
  }

  @Test
  void testOne() throws Exception {
    final int[][] costs = new int[][]{{7, 2, 6}};
    assertEquals(2, solution.minCost(costs));
  }

  @Test
  void testNormal() throws Exception {
    final int[][] costs = new int[][]{
        {4, 5, 6},
        {1, 20, 21}
    };
    assertEquals(6, solution.minCost(costs));
  }

  @Test
  void testNormal2() throws Exception {
    final int[][] costs = new int[][]{
        {4, 5, 6},
        {1, 20, 21},
        {2, 20, 21}
    };
    assertEquals(26, solution.minCost(costs));
  }

  @Test
  void testNormal3() throws Exception {
    final int[][] costs = new int[][]{
        {17, 2, 17},
        {16, 16, 5},
        {14, 3, 19}
    };
    assertEquals(10, solution.minCost(costs));
  }
}