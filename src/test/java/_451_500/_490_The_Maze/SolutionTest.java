package _451_500._490_The_Maze;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 12/3/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
//    solution = new DFSSolution();
    solution = new BFSSolution();
  }

  /**
   *
   * @throws Exception
   */
  @Test
  public void testOnlineCase1() throws Exception {
    final int[][] board = {
        {0, 0, 1, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 1, 0},
        {1, 1, 0, 1, 1},
        {0, 0, 0, 0, 0}
    };
    assertTrue(solution.hasPath(board, new int[] {0, 4}, new int[] {4, 4}));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final int[][] board = {
        {0, 0, 1, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 1, 0},
        {1, 1, 0, 1, 1},
        {0, 0, 0, 0, 0}
    };
    assertFalse(solution.hasPath(board, new int[] {0, 4}, new int[] {3, 2}));
  }

  @Test
  public void testOnlineCase3() throws Exception {
    final int[][] board = {
        {0, 0, 1, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 1, 0},
        {1, 1, 0, 1, 1},
        {0, 0, 0, 0, 0}
    };
    assertTrue(solution.hasPath(board, new int[] {0, 4}, new int[] {1, 2}));
  }

}
