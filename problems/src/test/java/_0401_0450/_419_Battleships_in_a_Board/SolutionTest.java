package _0401_0450._419_Battleships_in_a_Board;

import definition.TwoDimensionArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/29/2017.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
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
