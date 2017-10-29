package _401_450._419_Battleships_in_a_Board;

import org.junit.Before;
import org.junit.Test;

import utils.TwoDimensionArray;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/29/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final char[][] board = TwoDimensionArray.getCharBoard(new String[] {
        "X..X", "...X", "...X"
    });
    assertEquals(2, solution.countBattleships(board));
  }

}
