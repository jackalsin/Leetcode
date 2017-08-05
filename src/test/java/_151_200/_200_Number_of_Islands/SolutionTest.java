package _151_200._200_Number_of_Islands;

import org.junit.Before;
import org.junit.Test;

import utils.TwoDimensionArray;

import static org.junit.Assert.*;

/**
 * @author jacka
 * @version 1.0 on 8/5/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testExample1() throws Exception {
    final char[][] grid = getCharBoard(new String[] {
        "11110",
        "11010",
        "11000",
        "00000"
    });
    assertEquals(1, solution.numIslands(grid));
  }

  @Test
  public void testExample2() throws Exception {
    final char[][] grid = getCharBoard(new String[] {
        "11000",
        "11000",
        "00100",
        "00011"
    });
    assertEquals(3, solution.numIslands(grid));
  }

  @Test
  public void testEmpty() throws Exception {
    final char[][] grid = new char[][]{{}};
    assertEquals(0, solution.numIslands(grid));
  }


  private static char[][] getCharBoard(String[] input) {
    char[][] board = new char[input.length][input[0].length()];

    for(int row = 0; row < input.length; row++) {
      for(int col = 0; col < input[row].length(); col++) {
        board[row][col] = input[row].charAt(col);
      }
    }
    return board;
  }
}
