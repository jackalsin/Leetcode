package interviews.microsoft._419_Battleships_in_a_Board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TwoDimensionArray;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() throws Exception {
    final char[][] board = TwoDimensionArray.getCharBoard(new String[]{
        "X..X", "...X", "...X"
    });
    assertEquals(2, solution.countBattleships(board));
  }


}