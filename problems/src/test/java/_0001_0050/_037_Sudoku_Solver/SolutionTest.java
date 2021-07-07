package _0001_0050._037_Sudoku_Solver;

import definition.SudokuUtils;
import definition.TwoDimensionArray;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static _0001_0050._037_Sudoku_Solver.Solution.isValidInCol;
import static _0001_0050._037_Sudoku_Solver.Solution.isValidInSquare;
import static definition.TwoDimensionArray.TwoDimensionArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * @author jacka
 * @version 1.0 on 2/16/2017.
 */
public class SolutionTest {
  static Stream<Solution> solutionStream() {
    return Stream.of(
        new Solution()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testWithCase1(Solution solution) {
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
  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testWithIsValidInColWithDup(Solution solution) {
    final char[][] board = SudokuUtils.create2dSudokuArray(new String[]{
        "..9748...", "7........", ".2.1.9...", "..7...24.", ".64.1.59.", ".98...3..",
        "...8.3.2.", "........6", "...2759.."
    });
    board[3][0] = '7';
    assertFalse(isValidInCol(board, 0));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testWithIsValidInSquareWithDup(Solution solution) {
    final char[][] board = SudokuUtils.create2dSudokuArray(new String[]{
        "..9748...", "7........", ".2.1.9...", "..7...24.", ".64.1.59.", ".98...3..",
        "...8.3.2.", "........6", "...2759.."
    });
    board[0][0] = '7';
    assertFalse(isValidInSquare(board, 0, 0));
  }

}