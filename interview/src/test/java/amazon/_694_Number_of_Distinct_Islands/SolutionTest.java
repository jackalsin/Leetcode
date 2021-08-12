package amazon._694_Number_of_Distinct_Islands;

import definition.TwoDimensionArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/25/2017.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final String[] strs = {"11000", "11000", "00011", "00011"};
    final int[][] board = TwoDimensionArray.getIntBoard(strs);
    assertEquals(1, solution.numDistinctIslands(board));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final String[] strs = {
        "11011",
        "10000",
        "00001",
        "11011"};
    final int[][] board = TwoDimensionArray.getIntBoard(strs);
    assertEquals(3, solution.numDistinctIslands(board));
  }

}
