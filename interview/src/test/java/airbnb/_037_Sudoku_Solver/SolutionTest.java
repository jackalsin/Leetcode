package airbnb._037_Sudoku_Solver;

import definition.SudokuUtils;
import definition.TwoDimensionArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static airbnb._037_Sudoku_Solver.Solution.isValidCol;
import static airbnb._037_Sudoku_Solver.Solution.isValidSquare;
import static definition.TwoDimensionArray.TwoDimensionArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 1/22/2019.
 */
class SolutionTest {

  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void testWithCase1() {
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
  void testWithIsValidInColWithDup() {
    final char[][] board = SudokuUtils.create2dSudokuArray(new String[]{
        "..9748...", "7........", ".2.1.9...", "..7...24.", ".64.1.59.", ".98...3..",
        "...8.3.2.", "........6", "...2759.."
    });
    board[3][0] = '7';
    assertFalse(isValidCol(board, 0));
  }

  @Test
  void testWithIsValidInSquareWithDup() {
    final char[][] board = SudokuUtils.create2dSudokuArray(new String[]{
        "..9748...", "7........", ".2.1.9...", "..7...24.", ".64.1.59.", ".98...3..",
        "...8.3.2.", "........6", "...2759.."
    });
    board[0][0] = '7';
    assertFalse(isValidSquare(board, 0, 0));
  }
}