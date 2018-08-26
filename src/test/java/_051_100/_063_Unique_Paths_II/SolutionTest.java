package _051_100._063_Unique_Paths_II;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 4/24/2017.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void uniquePathsWithObstacles() throws Exception {
    int[][] input = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
    assertEquals(2, solution.uniquePathsWithObstacles(input));
  }

  @Test
  void testWith1by1() throws Exception {
    assertEquals(1, solution.uniquePathsWithObstacles(new int[][]{{0}}));
  }
}
