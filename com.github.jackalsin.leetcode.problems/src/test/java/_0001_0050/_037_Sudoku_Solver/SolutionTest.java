package _0001_0050._037_Sudoku_Solver;

import org.junit.Before;
import org.junit.Test;
import utils.SudokuUtils;
import utils.TwoDimensionArray;

import static _0001_0050._037_Sudoku_Solver.Solution.isValidInCol;
import static _0001_0050._037_Sudoku_Solver.Solution.isValidInSquare;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static utils.TwoDimensionArray.TwoDimensionArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 2/16/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testWithCase1() {
    final char[][] board = SudokuUtils.create2dSudokuArray(new String[]{
        "..9748...", "7........", ".2.1.9...", "..7...24.", ".64.1.59.", ".98...3..",
        "...8.3.2.", "........6", "...2759.."
    });

    final char[][] expected = SudokuUtils.create2dSudokuArray(new String[]{
        "519748632", "783652419", "426139875", "357986241", "264317598",
        "198524367", "975863124", "832491756", "641275983"
    });
    solution.solveSudoku(board);
    TwoDimensionArray.println(board);
    assertTrue(TwoDimensionArrayEquals(expected, board));
  }


  // test package-private method
  @Test
  public void testWithIsValidInColWithDup() {
    final char[][] board = SudokuUtils.create2dSudokuArray(new String[]{
        "..9748...", "7........", ".2.1.9...", "..7...24.", ".64.1.59.", ".98...3..",
        "...8.3.2.", "........6", "...2759.."
    });
    board[3][0] = '7';
    assertFalse(isValidInCol(board, 0));
  }

  @Test
  public void testWithIsValidInSquareWithDup() {
    final char[][] board = SudokuUtils.create2dSudokuArray(new String[]{
        "..9748...", "7........", ".2.1.9...", "..7...24.", ".64.1.59.", ".98...3..",
        "...8.3.2.", "........6", "...2759.."
    });
    board[0][0] = '7';
    assertFalse(isValidInSquare(board, 0, 0));
  }

}