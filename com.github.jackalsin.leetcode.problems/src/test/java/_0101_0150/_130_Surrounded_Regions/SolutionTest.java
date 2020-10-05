package _0101_0150._130_Surrounded_Regions;

import org.junit.Before;
import org.junit.Test;
import utils.TwoDimensionArray;

import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 7/2/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase() throws Exception {
    char[][] board = new char[][]{{'X', 'X', 'X', 'X'},
        {'X', 'O', 'O', 'X'},
        {'X', 'X', 'O', 'X'},
        {'X', 'O', 'X', 'X'}};
    solution.solve(board);
    char[][] expected = new char[][]{{'X', 'X', 'X', 'X'},
        {'X', 'X', 'X', 'X'},
        {'X', 'X', 'X', 'X'},
        {'X', 'O', 'X', 'X'}};
    assertTrue(TwoDimensionArray.TwoDimensionArrayEquals(expected, board));

  }
}