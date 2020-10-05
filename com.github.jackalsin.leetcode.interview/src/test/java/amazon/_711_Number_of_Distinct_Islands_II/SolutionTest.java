package amazon._711_Number_of_Distinct_Islands_II;

import org.junit.Before;
import org.junit.Test;

import utils.TwoDimensionArray;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/25/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final String[] strs = {
        "11000",
        "10000",
        "00001",
        "00011"};
    final int[][] board = TwoDimensionArray.getIntBoard(strs);
    assertEquals(1, solution.numDistinctIslands2(board));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final String[] strs = {
        "11100",
        "10001",
        "01001",
        "01110"};
    final int[][] board = TwoDimensionArray.getIntBoard(strs);
    assertEquals(2, solution.numDistinctIslands2(board));
  }

  @Test
  public void testFailedCase1() throws Exception {
    final String[] strs = {
        "001",
        "101"};
    final int[][] board = TwoDimensionArray.getIntBoard(strs);
    assertEquals(2, solution.numDistinctIslands2(board));
  }
}
