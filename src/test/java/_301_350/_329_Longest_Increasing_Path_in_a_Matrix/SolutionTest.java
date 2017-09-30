package _301_350._329_Longest_Increasing_Path_in_a_Matrix;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 9/29/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase() throws Exception {
    final int[][] board = {
        {9, 9, 4},
        {6, 6, 8},
        {2, 1, 1},
    };
    assertEquals(4, solution.longestIncreasingPath(board));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final int[][] board = {
        {3, 4, 5},
        {3, 2, 6},
        {2, 2, 1},
    };
    assertEquals(4, solution.longestIncreasingPath(board));
  }


}
