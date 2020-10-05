package microsoft.noodleEssence._794_Valid_Tic_Tac_Toe_State;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final String[] board = new String[]{"O  ", "   ", "   "};
//    The first player always plays "X".
    assertFalse(solution.validTicTacToe(board));
  }

  @Test
  void testOnlineCase2() {
    final String[] board = new String[]{"XOX", " X ", "   "};
//    The first player always plays "X".
    assertFalse(solution.validTicTacToe(board));
  }

  @Test
  void testOnlineCase3() {
    final String[] board = new String[]{"XXX", "   ", "OOO"};
//    The first player always plays "X".
    assertFalse(solution.validTicTacToe(board));
  }

  @Test
  void testOnlineCase4() {
    final String[] board = new String[]{"XOX", "O O", "XOX"};
//    The first player always plays "X".
    assertTrue(solution.validTicTacToe(board));
  }

  @Test
  void testOnlineCase5() {
    final String[] board = new String[]{"X  ", "X  ", "O O"};
//    The first player always plays "X".
    assertTrue(solution.validTicTacToe(board));
  }
}